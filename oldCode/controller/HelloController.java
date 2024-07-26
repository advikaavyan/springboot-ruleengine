package com.example.advikaavyan.adaptor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Operation(summary = "Get a greeting message")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved greeting"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
