package com.example.poc.flow.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InboundMessageDTO {
    private Long messageId;
    private String source;
    private String inMessage;
    private LocalDateTime receivedAt;

    // Getters and Setters
}
