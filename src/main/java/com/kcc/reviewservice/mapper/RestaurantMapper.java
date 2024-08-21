package com.kcc.reviewservice.mapper;

import com.kcc.reviewservice.entity.Restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    public List<Restaurant> findAllrestaurant();
    public void createRestaurant(Restaurant restaurant);
    public void deleteRestaurant(int id);
    public void modifyRestaurant(Restaurant restaurant);
    public List<Restaurant> infoRestaurant(int id);
}
