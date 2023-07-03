package com.example.application.services.implementation;

import com.example.application.model.Restaurant;
import com.example.application.repo.RestaurantRepo;
import com.example.application.services.RestaurantServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RestaurantServiceImpl implements RestaurantServices {
    private final RestaurantRepo restaurantRepo;
    @Override
    public Restaurant create(Restaurant restaurant) {
        log.info("Dodano nową restauracje: {}",restaurant.getName());
        restaurant.setImageUrl(setRestaurantImageUrl());
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Collection<Restaurant> list(int limit) {
        log.info("Wyszukaj wszystkie restauracje");
        return restaurantRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Restaurant get(Long id) {
        log.info("Wyszukaj restauracje przez id: {}", id);
        return restaurantRepo.findById(id).get();
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        log.info("Aktualizacja restauracji: {}",restaurant.getName());
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Usuń restaurację przez id: {}",id);
        restaurantRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setRestaurantImageUrl() {
        String[] imageNames = { "jedzenie1.png", "jedzenie2.png", "jedzenie3.png", "jedzenie4.png", "jedzenie5.png"};

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/restaurant/image/" + imageNames[new Random().nextInt(5)]).toUriString();
    }
}
