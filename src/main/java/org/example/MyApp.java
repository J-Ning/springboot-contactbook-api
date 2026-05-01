package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("testing start");
        System.out.println();
        SpringApplication.run(MyApp.class, args);
    }
}
