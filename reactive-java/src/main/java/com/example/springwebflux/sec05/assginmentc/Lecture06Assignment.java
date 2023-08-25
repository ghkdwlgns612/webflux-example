package com.example.springwebflux.sec05.assginmentc;

import com.example.springwebflux.courseutil.Util;

public class Lecture06Assignment {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream()
                .subscribe(revenueService.subscribeOrderStream());

        orderService.orderStream()
                .subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("Inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("Revenue"));

        Util.sleepSeconds(60);
    }
}
