package com.example.advikaavyan.adaptor.model.dto;

import lombok.Data;

@Data
public class AdaptorApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public AdaptorApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
}
