package com.example.advikaavyan.adaptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class}
)
*/
@SpringBootApplication

public class AdaptorApp {

    public static void main(String[] args) {
        SpringApplication.run(AdaptorApp.class, args);
    }


}
