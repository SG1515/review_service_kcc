package com.kcc.reviewservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements Serializable {

    private int id;

    private String name;

    private String address;

    private String created_at;

    private String updated_at;
}
