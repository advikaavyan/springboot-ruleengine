package com.example.flow.processor;

import com.example.flow.model.base.BaseContext;

public interface AdaptorProcessor {
    BaseContext execute(final BaseContext baseContext);
}
