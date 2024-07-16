package com.example.poc.flow.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutboundMessageMapper {

   /* @Autowired
    private MessageFlowTrackerMapper messageFlowTrackerMapper;

    public OutboundMessage toEntity(OutboundMessageDTO dto, MessageFlowTracker messageFlowTracker) {
        if (dto == null) {
            return null;
        }

        OutboundMessage entity = new OutboundMessage();
        entity.setOutboundMessageId(dto.getOutboundMessageId());
        entity.setMessageFlowTracker(messageFlowTracker);
        entity.setLegType(dto.getLegType());
        entity.setOutMessage(dto.getOutMessage());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;
    }

    public OutboundMessageDTO toDTO(OutboundMessage entity) {
        if (entity == null) {
            return null;
        }

        OutboundMessageDTO dto = new OutboundMessageDTO();
        dto.setOutboundMessageId(entity.getOutboundMessageId());
        dto.setMessageFlowTrackerId(entity.getMessageFlowTracker().getMessageFlowTrackerId());
        dto.setLegType(entity.getLegType());
        dto.setOutMessage(entity.getOutMessage());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }*/
}
