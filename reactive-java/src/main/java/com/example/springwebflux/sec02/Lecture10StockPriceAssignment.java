package com.example.springwebflux.sec02;

import com.example.springwebflux.sec02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lecture10StockPriceAssignment {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.subscription = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now() + " : Price : " + price);
                        if (price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        latch.countDown();

                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });
        latch.await();
    }
}
