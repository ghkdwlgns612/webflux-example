package com.example.springwebflux.sec03;

import com.example.springwebflux.courseutil.Util;
import com.example.springwebflux.sec03.assignment.FileReaderService;

import java.nio.file.Paths;

public class Lecture09FileReaderService {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();

        fileReaderService.readFile(Paths.get("src/main/resources//assignment/sec03/file01.txt"))
                .subscribe(Util.subscriber());
    }
}
