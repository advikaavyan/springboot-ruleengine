package com.example.advikaavyan.adaptor.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MessageDTO {
    private String messageIdentifier;
    private String source;
    private Timestamp receivedAt;
    private String message;
    private List<SignatureDTO> signatures;
    private List<LegDTO> legs;

    // Getters and Setters
}
