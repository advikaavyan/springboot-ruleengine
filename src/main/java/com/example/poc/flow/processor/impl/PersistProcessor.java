package com.example.poc.flow.processor.impl;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.processor.AdaptorProcessor;
import org.springframework.stereotype.Component;

@Component
public class PersistProcessor implements AdaptorProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {

        return baseContext;
    }
}
