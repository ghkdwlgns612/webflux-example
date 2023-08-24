package com.example.springwebflux.sec12;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec12.helper.BookService;
import com.example.springwebflux.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lecture02CtxRateLimiterDemo {

    public static void main(String[] args) {

        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(Util.subscriber());

    }
}
