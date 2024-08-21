package com.kcc.reviewservice.service;

import com.kcc.reviewservice.entity.Restaurant;
import com.kcc.reviewservice.entity.Review;
import com.kcc.reviewservice.mapper.RestaurantMapper;
import com.kcc.reviewservice.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public Review createReview(Review review) {
        reviewMapper.createReview(review);
        return review;
    }

    public void deleteReview(int id) {
        reviewMapper.deleteReview(id);
    }
}
