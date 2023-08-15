package com.example.springwebflux.sec01;

import java.util.stream.Stream;

public class Lecture01Stream {

    public static void main(String[] args) {
        final Stream<Integer> st = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });
        System.out.println(st);
        st.forEach(System.out::println);
    }
}
