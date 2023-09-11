package com.example.springwebflux.sec03;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {

    private int age;
    private String name;

    public Person() {
    }
}
