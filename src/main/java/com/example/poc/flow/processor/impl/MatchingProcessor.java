package com.example.poc.flow.processor.impl;


import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.context.MessageDataDto;
import com.example.poc.flow.model.dto.MatchingSignatureDTO;
import com.example.poc.flow.model.dto.MessageDataDTO;
import com.example.poc.flow.model.entity.MatchingSignature;
import com.example.poc.flow.ser.MatchingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class MatchingProcessor extends AbstractProcessor {

    private final MatchingService matchingService;

    public MatchingProcessor(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @Override
    public BaseContext execute(final BaseContext baseContext) {
        Transaction transaction = getLatestTransaction(baseContext);
        List<MatchingSignatureDTO> matchingSignatureDTOS = createMatchingKey(transaction);
        if (Objects.nonNull(getLatestTransaction(baseContext))) {
            List<MatchingSignature> matchingSignatures = getMatchingSignatures(matchingSignatureDTOS);
            if (matchingSignatures.isEmpty()) {
                transaction.getMatchingSignatures().addAll(matchingSignatureDTOS);
                log.info("Added matchingSignatureDTOS.......matchingSignatureDTOS matchingSignatureDTOS....");
                return baseContext;
            } else {
                log.info("need to load context from DB.............");
            }
        }
        return baseContext;
    }

    private List<MatchingSignature> getMatchingSignatures(List<MatchingSignatureDTO> matchingSignatureDTOS) {

        List<MatchingSignature> matches = matchingService.matches(matchingSignatureDTOS);
        // db call to get list of Signatures and convert into DTO
        return matches;
    }

    private List<MatchingSignatureDTO> createMatchingKey(Transaction transaction) {
        MessageDataDTO messageDataDto = transaction.getMessageData();
        List<MatchingSignatureDTO> matchingSignatureDTOs = new ArrayList<>();

        MatchingSignatureDTO matchingSignatureDTO = new MatchingSignatureDTO();
        matchingSignatureDTO.setMatchingKey("BME_HEADER_DUPE");
        matchingSignatureDTO.setMatchingValue(messageDataDto.getUuid());
        matchingSignatureDTOs.add(matchingSignatureDTO);

        MatchingSignatureDTO matchingSignatureDTO1 = new MatchingSignatureDTO();
        matchingSignatureDTO1.setMatchingKey("BASKET");
        matchingSignatureDTO1.setMatchingValue(messageDataDto.getVersion() + "");
        matchingSignatureDTOs.add(matchingSignatureDTO1);

        MatchingSignatureDTO matchingSignatureDTO2 = new MatchingSignatureDTO();
        matchingSignatureDTO2.setMatchingKey("NEWM_BASKET_VERSION_DUPE");
        String value = messageDataDto.getMessageFunction() + "|" + messageDataDto.getTransactionId() + "|" + messageDataDto.getVersion();
        matchingSignatureDTO2.setMatchingValue(value);

        matchingSignatureDTOs.add(matchingSignatureDTO2);

        // db call to get list of Signatures and convert into DTO
        return matchingSignatureDTOs;
    }


}
