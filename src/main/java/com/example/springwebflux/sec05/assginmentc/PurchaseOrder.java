package com.example.springwebflux.sec05.assginmentc;

import com.example.springwebflux.courseutil.Util;
import lombok.Data;

@Data
public class PurchaseOrder {
    private String item;
    private Double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
        this.quantity = Util.faker().random().nextInt(1, 10);
    }
}
