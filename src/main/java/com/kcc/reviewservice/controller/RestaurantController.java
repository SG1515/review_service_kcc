package com.kcc.reviewservice.controller;

import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping("/restaurants")
    public ResponseEntity createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);

        URI location = URI.create("/restaurants/" + restaurant.getId());

        return new ResponseEntity(HttpStatus.OK);
    }
}
