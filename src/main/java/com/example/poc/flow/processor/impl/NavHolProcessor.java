package com.example.poc.flow.processor.impl;

import com.example.poc.flow.processor.AdaptorProcessor;
import com.example.poc.flow.model.base.BaseContext;
import org.springframework.stereotype.Component;

@Component
public class NavHolProcessor implements AdaptorProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {

        return baseContext;
    }
}
