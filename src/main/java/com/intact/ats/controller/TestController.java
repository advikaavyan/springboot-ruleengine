package com.intact.ats.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;
    int counter = 0;

    @GetMapping("/test")
    public Map<String, Object> executePost(HttpServletRequest request) {
        log.info("test CALL CAME = ==  " + new Date() + ".");
        Map<String, Object> result = new HashMap<>();


        result.put("Msg:", "Hello App " + ++counter);
        result.put("Date:", new Date());
        result.put("URL:", request.getRequestURL());
        result.put("getRemoteUser:", request.getRemoteUser());
        result.put("IP:", request.getRemoteAddr());
        result.put("Port:", webServerAppCtxt.getWebServer().getPort());
        return result;


    }

}
