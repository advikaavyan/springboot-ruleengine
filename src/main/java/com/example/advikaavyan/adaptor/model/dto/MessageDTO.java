package com.example.advikaavyan.adaptor.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Getter
public class MessageDTO {
    private String messageIdentifier;
    private String source;
    private Timestamp receivedAt;
    private String message;
    private List<SignatureDTO> signatures;
    private List<LegDTO> legs;
}

