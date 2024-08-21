package com.kcc.reviewservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kcc.reviewservice.config.DefaultRes;
import com.kcc.reviewservice.config.ResponseMessage;
import com.kcc.reviewservice.config.StatusCode;
import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.entity.Review;
import com.kcc.reviewservice.dto.ReviewsDto;
import com.kcc.reviewservice.service.RestaurantService;
import com.kcc.reviewservice.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RestaurantController {

    private final ReviewService reviewService;
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService, ReviewService reviewService) {
        this.restaurantService = restaurantService;
        this.reviewService = reviewService;
    }

    @GetMapping("/restaurants")
    public MappingJacksonValue findAllRestaurants() {

        List<Restaurant> allRestaurants = restaurantService.getAllRestaurants();
        //필터를 어떤 것만 할 것인지 select
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "address", "created_at", "updated_at");
        //필터 등록하기.
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("restInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(allRestaurants);
        mapping.setFilters(filterProvider);

        return mapping;
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


    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewsDto findAllReviews(@PathVariable int restaurantId) {

        int avgScore = restaurantService.avgScore(restaurantId);
        List<Review> reviews = restaurantService.reviews(restaurantId);


        ReviewsDto reviewsDto = new ReviewsDto(avgScore, reviews);
        return reviewsDto;
    }



}
