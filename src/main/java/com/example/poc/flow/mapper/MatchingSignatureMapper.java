package com.example.poc.flow.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchingSignatureMapper {

   /* @Autowired
    private InboundMessageMapper inboundMessageMapper;

    public MatchingSignature toEntity(MatchingSignatureDTO dto, InboundMessage inboundMessage) {
        if (dto == null) {
            return null;
        }

        MatchingSignature entity = new MatchingSignature();
        entity.setMatchingSignatureId(dto.getMatchingSignatureId());
        entity.setInboundMessage(inboundMessage);
        entity.setMatchingKey(dto.getMatchingKey());
        entity.setMatchingValue(dto.getMatchingValue());
        entity.setIsValid(dto.getIsValid());

        return entity;
    }

    public MatchingSignatureDTO toDTO(MatchingSignature entity) {
        if (entity == null) {
            return null;
        }

        MatchingSignatureDTO dto = new MatchingSignatureDTO();
        dto.setMatchingSignatureId(entity.getMatchingSignatureId());
        dto.setMessageId(entity.getInboundMessage().getMessageId());
        dto.setMatchingKey(entity.getMatchingKey());
        dto.setMatchingValue(entity.getMatchingValue());
        dto.setIsValid(entity.getIsValid());

        return dto;
    }*/
}
