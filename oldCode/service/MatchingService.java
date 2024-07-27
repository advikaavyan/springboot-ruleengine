package com.example.advikaavyan.adaptor.service;

import com.example.advikaavyan.adaptor.dao.SignatureRepository;
import com.example.poc.flow.model.context.MessageDataDto;
import com.example.poc.flow.model.context.SignatureDto;

import java.util.List;

public class MatchingService {
    private final SignatureRepository signatureRepository;

    public MatchingService(SignatureRepository signatureRepository) {
        this.signatureRepository = signatureRepository;
    }

    public List<SignatureDto> matches(MessageDataDto messageDataDto) {
        signatureRepository.findAll();

        return List.of(new SignatureDto());

    }
}
