package com.example.poc.flow.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InboundMessageDTO {
    private Long messageId;
    private String messageIdentifier;
    private String messageFunction;
    private String source;
    private String inMessage;
    private LocalDateTime receivedAt;

    // Getters and Setters
}
