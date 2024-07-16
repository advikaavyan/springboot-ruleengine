package com.example.poc.flow.ser;

import com.example.poc.flow.model.dto.MatchingSignatureDTO;
import com.example.poc.flow.model.entity.MatchingSignature;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchingService {
    private final MatchingSignatureDaoService matchingSignatureDaoService;

    public MatchingService(MatchingSignatureDaoService matchingSignatureDaoService) {
        this.matchingSignatureDaoService = matchingSignatureDaoService;
    }

    public List<MatchingSignature> matches(List<MatchingSignatureDTO> matchingSignatureDTOs) {
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

        for (MatchingSignatureDTO matchingSignatureDTO : matchingSignatureDTOs) {
            keys.add(matchingSignatureDTO.getMatchingKey());
            values.add(matchingSignatureDTO.getMatchingValue());
        }

        return matchingSignatureDaoService.findByMatchingKeysAndMatchingValues(keys, values);


    }
}
