package com.kcc.reviewservice.mapper;

import com.kcc.reviewservice.entity.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    public void createReview(Review review);
    public void deleteReview(int id);
}
