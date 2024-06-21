package com.example.advikaavyan.adaptor.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;


@Data
public class OutMessage {
    private String source;
    private String message;
    private Long messageId;
    private String messageType;
    private LocalDateTime createdAt;

}
