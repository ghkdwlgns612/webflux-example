package com.example.springwebflux.sec04;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec04.helper.OrderService;
import com.example.springwebflux.sec04.helper.UserService;

public class Lecture12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .concatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }

}
