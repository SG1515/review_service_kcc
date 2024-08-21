package com.kcc.reviewservice.service;

import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    public List<Restaurant> getAllRestaurants() {
        return restaurantMapper.findAllrestaurant();
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurantMapper.createRestaurant(restaurant);
        return restaurant;
    }
}
