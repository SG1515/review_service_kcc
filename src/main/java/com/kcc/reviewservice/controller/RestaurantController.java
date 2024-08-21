package com.kcc.reviewservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @GetMapping("/test")
    public String start() {
        return "hello test!!";
    }
}
