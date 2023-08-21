package com.example.springwebflux.sec05.assignment;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String item;
    private double price;

    public Order(String id, String item, double price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }
}
