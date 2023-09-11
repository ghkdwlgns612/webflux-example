package com.example.springwebflux.sec02;

import com.example.springwebflux.courseutil.DefaultSubscriber;
import com.example.springwebflux.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class Lecture03 {

    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Recieved Subsription");
                        atomicReference.set(subscription);
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Custom on Next : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Throwable : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });
        Util.sleepSeconds(1);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(4);
        Util.sleepSeconds(7);
        atomicReference.get().cancel();
        Util.sleepSeconds(2);
        atomicReference.get().request(4);

    }
}
