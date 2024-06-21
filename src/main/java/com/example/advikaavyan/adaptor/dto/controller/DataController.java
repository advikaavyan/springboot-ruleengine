package com.example.advikaavyan.adaptor.dto.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.*;

@RestController
@Slf4j
public class DataController {
    @Autowired
    DataSource dataSource;
    @GetMapping("/data")
    public void executePost(HttpServletRequest request) {
        System.out.println(dataSource);



    }




}
