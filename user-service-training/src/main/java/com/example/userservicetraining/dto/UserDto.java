package com.example.userservicetraining.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private Integer id;
    private String name;
    private Integer balance;
}
