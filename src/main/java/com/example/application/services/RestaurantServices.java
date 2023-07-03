package com.example.application.services;

import com.example.application.model.Restaurant;

import java.util.Collection;

public interface RestaurantServices {
    Restaurant create(Restaurant restaurant);
    Collection<Restaurant> list(int limit);
    Restaurant get(Long id);
    Restaurant update(Restaurant restaurant);
    Boolean delete(Long id);

}
