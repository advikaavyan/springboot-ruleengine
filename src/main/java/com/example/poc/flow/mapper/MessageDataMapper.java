package com.example.poc.flow.mapper;

import org.springframework.stereotype.Component;

@Component
public class MessageDataMapper {

    /*@Autowired
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
    }*/
}
