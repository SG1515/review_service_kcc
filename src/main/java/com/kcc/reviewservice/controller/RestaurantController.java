package com.kcc.reviewservice.controller;

import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> findAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}
