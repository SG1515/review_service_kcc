package com.kcc.reviewservice.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @Pattern(regexp = "(([가-힣]|\\\\d)+(시 ))+(([가-힣]|\\\\d)+(구))")
    private String address;

    private String created_at;

    private String updated_at;
}
