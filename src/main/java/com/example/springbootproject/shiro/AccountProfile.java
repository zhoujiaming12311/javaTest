package com.example.springbootproject.shiro;

import lombok.Data;

import java.io.Serializable;

import java.time.LocalDateTime;

@Data
public class AccountProfile implements Serializable {
    private Long id;

    private String username;

    private String avatar;

    private String email;

    private String parssowrd;

    private Integer status;

    private LocalDateTime created;
}
