package com.example.advikaavyan.adaptor.model.dto;

import lombok.Data;

@Data
public class LegDTO {
    private String legType;
    private String status;
    private String subStatus;
    private String createdAt;
    private boolean inFlight;

    // Getters and Setters
}
