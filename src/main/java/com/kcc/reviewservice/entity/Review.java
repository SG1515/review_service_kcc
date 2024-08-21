package com.kcc.reviewservice.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {
    private int id;
    private int restaurant_id;

    @NotNull
    private String content;

    @NotNull
    private double score;
    private Timestamp created_at;

}
