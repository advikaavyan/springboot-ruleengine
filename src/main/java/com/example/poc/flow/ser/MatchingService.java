package com.example.poc.flow.ser;

import com.example.poc.flow.model.base.MatchingKey;
import com.example.poc.flow.model.base.Transaction;
import com.example.poc.flow.model.dto.MatchingSignatureDTO;
import com.example.poc.flow.model.dto.MessageDataDTO;
import com.example.poc.flow.model.entity.MatchingSignature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MatchingService {
    private final MatchingSignatureDaoService matchingSignatureDaoService;

    public MatchingService(MatchingSignatureDaoService matchingSignatureDaoService) {
        this.matchingSignatureDaoService = matchingSignatureDaoService;
    }

    public List<MatchingSignature> getMatchingSignatures(List<MatchingSignatureDTO> matchingSignatureDTOS) {
        return matches(matchingSignatureDTOS);
    }

    public List<MatchingSignature> getMatchingSignatures(List<MatchingSignatureDTO> matchingSignatureDTOS, List<MatchingSignatureDTO> linkedMatchingSignatureDTOS) {
        return matches(matchingSignatureDTOS, linkedMatchingSignatureDTOS);
    }

    public Map<MatchingKey, MatchingSignature> ListToMap(List<MatchingSignature> matchingSignatures) {
        Map<MatchingKey, MatchingSignature> matchingSignatureMap = new HashMap<>();
        for (MatchingSignature matchingSignature : matchingSignatures) {
            matchingSignatureMap.put(matchingSignature.getMatchingKey(), matchingSignature);
        }
        return matchingSignatureMap;
    }


    public List<MatchingSignatureDTO> createLinkedMatchingKeys(Transaction transaction) {
        MessageDataDTO messageDataDto = transaction.getMessageData();
        List<MatchingSignatureDTO> matchingSignatureDTOs = new ArrayList<>();


        MatchingSignatureDTO matchingSignatureDTO1 = new MatchingSignatureDTO();


        if ("NEWM".equals(transaction.getMessageData().getMessageFunction())) {

            matchingSignatureDTO1.setMatchingKey(MatchingKey.CANC_BASKET);
            matchingSignatureDTO1.setMatchingValue(messageDataDto.getMessageIdentifier() + "");


        }
        if ("CANC".equals(transaction.getMessageData().getMessageFunction())) {

            matchingSignatureDTO1.setMatchingKey(MatchingKey.NEWM_BASKET);
            matchingSignatureDTO1.setMatchingValue(messageDataDto.getMessageIdentifier() + "");

        }
        matchingSignatureDTOs.add(matchingSignatureDTO1);
        return matchingSignatureDTOs;
    }

    public List<MatchingSignatureDTO> createMatchingKeys(Transaction transaction) {
        MessageDataDTO messageDataDto = transaction.getMessageData();
        List<MatchingSignatureDTO> matchingSignatureDTOs = new ArrayList<>();

        MatchingSignatureDTO matchingSignatureDTO = new MatchingSignatureDTO();
        matchingSignatureDTO.setMatchingKey(MatchingKey.BME_HEADER_DUPE);
        matchingSignatureDTO.setMatchingValue(messageDataDto.getUuid());
        matchingSignatureDTOs.add(matchingSignatureDTO);

        MatchingSignatureDTO matchingSignatureDTO1 = new MatchingSignatureDTO();


        MatchingSignatureDTO matchingSignatureDTO2 = new MatchingSignatureDTO();

        if ("NEWM".equals(transaction.getMessageData().getMessageFunction())) {

            matchingSignatureDTO1.setMatchingKey(MatchingKey.NEWM_BASKET);
            matchingSignatureDTO1.setMatchingValue(messageDataDto.getMessageIdentifier() + "");

            matchingSignatureDTO2.setMatchingKey(MatchingKey.NEWM_BASKET_VERSION_DUPE);
            String value = messageDataDto.getMessageFunction() + "|" + messageDataDto.getMessageIdentifier() + "|" + messageDataDto.getVersion();
            matchingSignatureDTO2.setMatchingValue(value);
        }
        if ("CANC".equals(transaction.getMessageData().getMessageFunction())) {

            matchingSignatureDTO1.setMatchingKey(MatchingKey.CANC_BASKET);
            matchingSignatureDTO1.setMatchingValue(messageDataDto.getMessageIdentifier() + "");

            matchingSignatureDTO2.setMatchingKey(MatchingKey.CANC_BASKET_VERSION_DUPE);
            String value = messageDataDto.getMessageFunction() + "|" + messageDataDto.getMessageIdentifier() + "|" + messageDataDto.getVersion();
            matchingSignatureDTO2.setMatchingValue(value);
        }
        matchingSignatureDTOs.add(matchingSignatureDTO1);
        matchingSignatureDTOs.add(matchingSignatureDTO2);

        return matchingSignatureDTOs;
    }

    private List<MatchingSignature> matches(List<MatchingSignatureDTO> matchingSignatureDTOs, List<MatchingSignatureDTO> linkedMatchingSignatureDTOS) {
        List<MatchingKey> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (MatchingSignatureDTO matchingSignatureDTO : matchingSignatureDTOs) {
            keys.add(matchingSignatureDTO.getMatchingKey());
            values.add(matchingSignatureDTO.getMatchingValue());
        }

        for (MatchingSignatureDTO matchingSignatureDTO : linkedMatchingSignatureDTOS) {
            keys.add(matchingSignatureDTO.getMatchingKey());
            values.add(matchingSignatureDTO.getMatchingValue());
        }
        return matchingSignatureDaoService.findByMatchingKeysAndMatchingValues(keys, values);

    }

    private List<MatchingSignature> matches(List<MatchingSignatureDTO> matchingSignatureDTOs) {
        List<MatchingKey> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (MatchingSignatureDTO matchingSignatureDTO : matchingSignatureDTOs) {
            keys.add(matchingSignatureDTO.getMatchingKey());
            values.add(matchingSignatureDTO.getMatchingValue());
        }
        log.info("```````````````````````````````````````````````````````Search is going with keys {} ", keys);
        log.info("```````````````````````````````````````````````````````Search is going with values {} ", values);
        return matchingSignatureDaoService.findByMatchingKeysAndMatchingValues(keys, values);

    }


}
