package com.example.springwebflux.sec01;

import com.example.springwebflux.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture08MonoFromRunnable {

    //아무것도 리턴하지 않음. 시간이 오래걸리는 일의 알람기능으로 사용하면 됨.
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("process is done. Sending emails..."));
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
