package com.kcc.reviewservice.config;

import lombok.Data;

@Data
public class LoginReq {
    private String name;
    private String password;
}
