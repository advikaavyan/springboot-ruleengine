package com.example.poc.flow.processor;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Transaction;

public interface AdaptorProcessor {
    BaseContext execute(final BaseContext baseContext);

}
