package com.kcc.reviewservice.service;

import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.entity.Review;
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

    public void deleteRestaurant(int id) {
        restaurantMapper.deleteRestaurant(id);
    }

    public void modifyRestaurant(Restaurant restaurant) {
        restaurantMapper.modifyRestaurant(restaurant);
    }

    public List<Restaurant> infoRestaurant(int id) {

        return  restaurantMapper.infoRestaurant(id);
    }

    public int avgScore(int id) {

        return restaurantMapper.avgScore(id);
    }

    public List<Review> reviews(int id){
        return restaurantMapper.reviews(id);
    }
}
