package com.example.poc.flow.mapper;

import com.example.poc.flow.model.base.Message;
import com.example.poc.flow.model.dto.MessageDataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class MessageDataMapper {

    public MessageDataDTO toMessageDataDTO(Message<String> message) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MessageDataDTO message1 = null;
        try {
            message1 = objectMapper.readValue(message.getContent(), MessageDataDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        message1.setRawMessage(message.getContent());
        return message1;

    }

    public MessageDataDTO toMessageDataDTO(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MessageDataDTO message1 = null;
        try {
            message1 = objectMapper.readValue(message, MessageDataDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        message1.setRawMessage(message);
        return message1;

    }
}
