package com.example.springwebflux.sec09.helper;

import com.example.springwebflux.courseutil.Util;
import lombok.Data;

@Data
public class Product {
    private String name;
    private double price;

    public Product() {
        name = Util.faker().commerce().productName();
        price = Double.parseDouble(Util.faker().commerce().price());
    }
}
