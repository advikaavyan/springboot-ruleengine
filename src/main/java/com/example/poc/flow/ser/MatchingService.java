package com.example.poc.flow.ser;

import com.example.poc.flow.model.context.MessageDataDto;
import com.example.poc.flow.model.context.SignatureDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingService {
    private final MatchingSignatureDaoService matchingSignatureDaoService;

    public MatchingService(MatchingSignatureDaoService matchingSignatureDaoService) {
        this.matchingSignatureDaoService = matchingSignatureDaoService;
    }

    public List<SignatureDto> matches(MessageDataDto messageDataDto) {
        matchingSignatureDaoService.findAll();

        return List.of(new SignatureDto());

    }
}
