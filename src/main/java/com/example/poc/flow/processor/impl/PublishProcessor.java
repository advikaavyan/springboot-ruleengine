package com.example.poc.flow.processor.impl;

import com.example.poc.flow.processor.AdaptorProcessor;
import com.example.poc.flow.model.base.BaseContext;
import org.springframework.stereotype.Component;

@Component
public class PublishProcessor extends AbstractProcessor {
    @Override
    public BaseContext execute(final BaseContext baseContext) {
        super.execute(baseContext);
        return baseContext;
    }
}
