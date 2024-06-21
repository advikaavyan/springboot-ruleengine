package com.example.advikaavyan.adaptor.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class InMessageResponse {
    private Long messageId; private String source;
    private String message;
    private LocalDateTime receivedAt;
    List<OutMessage> outMessages;


}
