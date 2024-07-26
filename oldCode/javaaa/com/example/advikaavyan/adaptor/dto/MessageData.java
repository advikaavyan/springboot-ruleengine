package com.example.advikaavyan.adaptor.dto;

import lombok.Data;

import java.util.List;

@Data
public class MessageData {


    private String uuid;
    private String messageIdentifier;
    private String source;
    private String message;
    private List<SignatureData> signatures;
    private List<FlowTrackerData> flowTrackers;

    // Getters and Setters
}
