package com.example.poc.flow.mapper;

import com.example.poc.flow.model.dto.MessageDataDTO;
import com.example.poc.flow.model.entity.InboundMessage;
import com.example.poc.flow.model.entity.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDataMapper {

    @Autowired
    private InboundMessageMapper inboundMessageMapper;

    public MessageData toEntity(MessageDataDTO dto, InboundMessage inboundMessage) {
        if (dto == null) {
            return null;
        }

        MessageData entity = new MessageData();
        entity.setInboundMessage(inboundMessage);
        entity.setAccountNumber(dto.getAccountNumber());

        return entity;
    }

    public MessageDataDTO toDTO(MessageData entity) {
        if (entity == null) {
            return null;
        }

        MessageDataDTO dto = new MessageDataDTO();
        dto.setMessageId(entity.getMessageDataId());
        dto.setMessageId(entity.getInboundMessage().getMessageId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setTradeDate(entity.getTradeDate());
        dto.setSenderBic(entity.getSenderBic());

        return dto;
    }
}
