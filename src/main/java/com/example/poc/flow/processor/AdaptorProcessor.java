package com.example.poc.flow.processor;

import com.example.poc.flow.model.base.BaseContext;

public interface AdaptorProcessor {
    BaseContext execute(final BaseContext baseContext);
}
