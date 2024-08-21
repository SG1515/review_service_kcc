package com.kcc.reviewservice.controller;

import com.kcc.reviewservice.config.DefaultRes;
import com.kcc.reviewservice.config.ResponseMessage;
import com.kcc.reviewservice.config.StatusCode;
import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping("/restaurant/{id}")
    public List<Restaurant> infoRestaurant(@PathVariable int id) {
        return restaurantService.infoRestaurant(id);
    }

    @PostMapping("/restaurants")
    public ResponseEntity createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRestaurant.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable int restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.DELETE_RESTAURANT), HttpStatus.OK);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public ResponseEntity modifyRestaurant(@PathVariable int restaurantId, @Valid @RequestBody Restaurant restaurant) {
        restaurant.setId(restaurantId);
        restaurantService.modifyRestaurant(restaurant);

        if (restaurant.getName().isEmpty()) {
            return new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.UPDATE_FAIL), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_RESTAURANT), HttpStatus.OK);
    }






}
