package com.example.advikaavyan.adaptor.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

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

