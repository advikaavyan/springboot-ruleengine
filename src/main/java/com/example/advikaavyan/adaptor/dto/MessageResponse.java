package com.example.advikaavyan.adaptor.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MessageResponse {
    private String messageIdentifier;
    private String errorCode;
    private Timestamp receivedAt;
    private String message;
    private List<SignatureDTO> signatures;
    private List<LegDTO> legs;
}
 
