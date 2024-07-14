package com.example.flow.processor;

import com.example.flow.model.base.BaseContext;
import com.example.flow.model.base.Message;

public interface ContextBuilder {
    BaseContext buildContext(Message message);
}
