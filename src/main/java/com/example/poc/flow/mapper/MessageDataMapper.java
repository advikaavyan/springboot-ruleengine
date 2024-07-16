package com.example.poc.flow.mapper;

import com.example.poc.flow.model.context.MessageDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDataMapper {

    /*@Autowired
    private InboundMessageMapper inboundMessageMapper;

    public MessageData toEntity(MessageDataDto dto, InboundMessage inboundMessage) {
        if (dto == null) {
            return null;
        }

        MessageData entity = new MessageData();
        entity.setMessageDataId(dto.getMessageDataId());
        entity.setInboundMessage(inboundMessage);
        entity.setAccountNumber(dto.getAccountNumber());
        entity.setTradeDate(dto.getTradeDate());
        entity.setSenderBic(dto.getSenderBic());

        return entity;
    }

    public MessageDataDTO toDTO(MessageData entity) {
        if (entity == null) {
            return null;
        }

        MessageDataDTO dto = new MessageDataDTO();
        dto.setMessageDataId(entity.getMessageDataId());
        dto.setMessageId(entity.getInboundMessage().getMessageId());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setTradeDate(entity.getTradeDate());
        dto.setSenderBic(entity.getSenderBic());

        return dto;
    }*/
}
