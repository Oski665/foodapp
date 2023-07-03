package com.example.application.controller;

//import com.example.application.enumeration.Status;
import com.example.application.model.Response;
import com.example.application.model.Restaurant;
import com.example.application.services.implementation.RestaurantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

//import static com.example.application.enumeration.Status.*;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    @GetMapping("/list")
    public ResponseEntity<Response> gerRestaurant(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp( now())
                        .data(Map.of("restaurants",restaurantService.list(30)))
                        .message("Restauracje wyszukane")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveRestaurant(@RequestBody @Valid Restaurant restaurant){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp( now())
                        .data(Map.of("restaurants",restaurantService.create(restaurant)))
                        .message("Restauracja utworzona")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRestaurant(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp( now())
                        .data(Map.of("restaurants",restaurantService.get(id)))
                        .message("Restauracja o podanym id została odnaleziona")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRestaurant(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp( now())
                        .data(Map.of("deleted",restaurantService.delete(id)))
                        .message("Restauracja o podanym id została usunięta")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getRestaurantImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Desktop/img/" + fileName));
    }

}
