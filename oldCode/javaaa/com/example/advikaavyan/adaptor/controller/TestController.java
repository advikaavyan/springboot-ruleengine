package com.example.advikaavyan.adaptor.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;
    int counter = 0;

    @GetMapping("/test")
    public Map<String, Object> executePost(HttpServletRequest request) {
        log.info("test CALL CAME = ==  " + new Date() + ".");
        System.out.println("Inside test end point");
        new RequestPrintHelper().printAll(request);
        Map<String, Object> result = new HashMap<>();


        result.put("Msg:", "Hello App " + ++counter);
        result.put("Date:", new Date());
        result.put("URL:", request.getRequestURL());
        result.put("getRemoteUser:", request.getRemoteUser());
        result.put("IP:", request.getRemoteAddr());
        result.put("Port:", webServerAppCtxt.getWebServer().getPort());
        return result;


    }



    @GetMapping("/holdTransactions")
    public List<String> holdTransactions(HttpServletRequest request) {
        log.info("holdTransactions CALL CAME = ==  " + new Date() + ".");
        return Arrays.asList("Transaction ID 1 " + new Date(), "Transaction ID 2 " + new Date());
    }

    @GetMapping("/reprocess")
    public String reprocess(String transactionId, String transactionFunction) {
        log.info("reprocess CALL CAME = ==  " + new Date() + ".");
        return transactionId + " : " + transactionFunction + " has been received and forwarded for re processing";
    }



}
