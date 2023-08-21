package com.example.springwebflux.sec05.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RevenueService {

    private static double revenue = 0.0;

    public static Subscriber<Object> subscriber() {
        return new RevenueSubscriber();
    }

    private static class RevenueSubscriber implements Subscriber<Object> {

        private String name = "";

        @Override
        public void onSubscribe(Subscription s) {
            s.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(Object o) {
            Order order = (Order) o;
            revenue += order.getPrice();
            System.out.println("Revenue generated for order: " + order.getId() + " is: " + revenue);
        }

        @Override
        public void onError(Throwable t) {
            System.out.println(name + " ERROR: " + t.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println(name + " completed");
        }
    }

}
