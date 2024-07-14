package com.example.poc.flow.processor;

import com.example.poc.flow.model.base.BaseContext;
import com.example.poc.flow.model.base.Message;

public interface ContextBuilder {
    BaseContext buildContext(Message message);
}
