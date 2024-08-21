package com.kcc.reviewservice.dto;


import com.kcc.reviewservice.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDto {
    private int avgScore;

    private List<Review> reviews;


}
