package com.kcc.reviewservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private int id;

    private String name;

    private String address;

    private String created_at;

    private String updated_at;
}
