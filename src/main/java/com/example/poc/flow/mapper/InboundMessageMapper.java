package com.example.poc.flow.mapper;

import com.example.poc.flow.model.context.MessageDataDto;
import com.example.poc.flow.model.dto.InboundMessageDTO;
import com.example.poc.flow.model.entity.InboundMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InboundMessageMapper {

    public InboundMessage toEntity(InboundMessageDTO dto) {
        if (dto == null) {
            return null;
        }

        InboundMessage entity = new InboundMessage();
        entity.setMessageId(dto.getMessageId());
        entity.setSource(dto.getSource());
        entity.setInMessage(dto.getInMessage());
        entity.setReceivedAt(dto.getReceivedAt());

        return entity;
    }

    public InboundMessage toEntity(MessageDataDto dto) {
        if (dto == null) {
            return null;
        }

        InboundMessage entity = new InboundMessage();

        entity.setSource(dto.getSource());
        entity.setInMessage(dto.getRawMessage());
        entity.setReceivedAt(LocalDateTime.now());

        return entity;
    }

    public InboundMessageDTO toDTO(InboundMessage entity) {
        if (entity == null) {
            return null;
        }

        InboundMessageDTO dto = new InboundMessageDTO();
        dto.setMessageId(entity.getMessageId());
        dto.setSource(entity.getSource());
        dto.setInMessage(entity.getInMessage());
        dto.setReceivedAt(entity.getReceivedAt());

        return dto;
    }
}
