package com.example.springwebflux.sec10;

import com.example.springwebflux.courseutil.Util;
import reactor.util.context.Context;

public class Lecture {

    public static void main(String[] args) {

        BookService.getBook()
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());

    }
}
