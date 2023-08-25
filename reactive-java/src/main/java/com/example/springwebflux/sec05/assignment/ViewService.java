package com.example.springwebflux.sec05.assignment;

import com.example.springwebflux.courseutil.Util;

public class ViewService {

    public static void main(String[] args) {
        OrderService.getOrders()
                .subscribe(RevenueService.subscriber());

        Util.sleepSeconds(60);
    }
}
