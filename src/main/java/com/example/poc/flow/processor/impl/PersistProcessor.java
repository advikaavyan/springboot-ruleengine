package com.example.poc.flow.processor.impl;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.processor.AdaptorProcessor;
import com.example.poc.flow.ser.PersistService;
import org.springframework.stereotype.Component;

@Component
public class PersistProcessor implements AdaptorProcessor {

    private final PersistService persistService;

    public PersistProcessor(PersistService persistService) {
        this.persistService = persistService;
    }

    @Override
    public BaseContext execute(final BaseContext baseContext) {
        persistService.persist(baseContext);
        return baseContext;
    }
}
