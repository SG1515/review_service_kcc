package com.kcc.reviewservice.controller;

import com.kcc.reviewservice.config.DefaultRes;
import com.kcc.reviewservice.config.ResponseMessage;
import com.kcc.reviewservice.config.StatusCode;
import com.kcc.reviewservice.entity.Review;
import com.kcc.reviewservice.service.ReviewService;
import jakarta.validation.Valid;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review")
    public ResponseEntity review(@Valid @RequestBody Review review) {
        reviewService.createReview(review);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.REVIEW_OK, "리뷰 글번호 : " +review.getId()), HttpStatus.OK);
    }


    @DeleteMapping("/review/{id}")
    public ResponseEntity deleteReview(@PathVariable int id) {
        String reviewNum = "" + id;
        reviewService.deleteReview(id);


        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.REVIEW_DELETE, "리뷰 글번호 : " + reviewNum + "가 삭제되었습니다."), HttpStatus.OK);
    }


}
