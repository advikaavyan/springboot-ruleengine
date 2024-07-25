package com.example.poc.flow.mapper;

import com.example.poc.flow.model.dto.MessageFlowTrackerDTO;
import com.example.poc.flow.model.entity.InboundMessage;
import com.example.poc.flow.model.entity.MessageFlowTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageFlowTrackerMapper {

    @Autowired
    private InboundMessageMapper inboundMessageMapper;

    public MessageFlowTracker toEntity(MessageFlowTrackerDTO dto, InboundMessage inboundMessage) {
        if (dto == null) {
            return null;
        }

        MessageFlowTracker entity = new MessageFlowTracker();
        entity.setMessageFlowTrackerId(dto.getMessageFlowTrackerId());
        entity.setInboundMessage(inboundMessage);
        entity.setLegType(dto.getLegType());
        entity.setStatus(dto.getStatus());
        entity.setSubStatus(dto.getSubStatus());
        entity.setScheduleReleaseAt(dto.getScheduleReleaseAt());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setInFlight(dto.getInFlight());
        entity.setInFlightExpiredAt(dto.getInFlightExpiredAt());

        return entity;
    }

    public MessageFlowTrackerDTO toDTO(MessageFlowTracker entity) {
        if (entity == null) {
            return null;
        }

        MessageFlowTrackerDTO dto = new MessageFlowTrackerDTO();
        dto.setMessageFlowTrackerId(entity.getMessageFlowTrackerId());
        dto.setMessageId(entity.getInboundMessage().getMessageId());
        dto.setLegType(entity.getLegType());
        dto.setStatus(entity.getStatus());
        dto.setSubStatus(entity.getSubStatus());
        dto.setScheduleReleaseAt(entity.getScheduleReleaseAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setInFlight(entity.getInFlight());
        dto.setInFlightExpiredAt(entity.getInFlightExpiredAt());

        return dto;
    }

    public List<MessageFlowTrackerDTO> toDTO(List<MessageFlowTracker> entities) {
        List<MessageFlowTrackerDTO> dtos = new ArrayList<>();
        for (MessageFlowTracker messageFlowTracker : entities) {
            dtos.add(toDTO(messageFlowTracker));
        }

        return dtos;
    }
}
