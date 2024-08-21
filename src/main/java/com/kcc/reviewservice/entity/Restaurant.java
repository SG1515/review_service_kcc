package com.kcc.reviewservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class Restaurant implements Serializable {


    private int id;

    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @Pattern(regexp = "(([가-힣]|\\\\d)+(시 ))+(([가-힣]|\\\\d)+(구))")
    private String address;

    private Timestamp created_at;

    private Timestamp updated_at;

    private List<RestaurantMenu> menus;

    public Restaurant(int id, String name, String address, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
