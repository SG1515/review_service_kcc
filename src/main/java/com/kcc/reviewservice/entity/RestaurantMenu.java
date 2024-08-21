package com.kcc.reviewservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantMenu implements Serializable {
    private int id;
    private int restaurant_id;
    private String name;
    private int price;
    private Timestamp created_at;
    private Timestamp updated_at;
}
