package com.example.application;

//import com.example.application.enumeration.Status;
import com.example.application.model.Restaurant;
import com.example.application.repo.RestaurantRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.helpers.LaunchUtil;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));

    }

    CommandLineRunner run(RestaurantRepo restaurantRepo){
        return args -> {
            restaurantRepo.save(new Restaurant(1L,"U Jasia","20","10","20",,"httlp://localhost:8080/restaurant/image/jedzenie1"));

        };
    }

}
