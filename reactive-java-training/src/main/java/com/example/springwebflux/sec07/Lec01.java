package com.example.springwebflux.sec07;

import com.example.springwebflux.courseutil.Util;

public class Lec01 {
    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));

        nameGenerator.generateNames()
                .filter(s -> s.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("Marshal"));
    }
}
