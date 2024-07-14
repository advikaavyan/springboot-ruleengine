package com.example.flow.processor.impl;

import com.example.flow.processor.AdaptorProcessor;
import com.example.flow.model.base.BaseContext;
import org.springframework.stereotype.Component;

@Component
public class OutboundProcessor implements AdaptorProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {

        return baseContext;
    }
}
