package com.example.poc.flow;


import com.example.poc.flow.model.base.Message;

public interface Flow {
    void executeMessageFlow(Message message);
}
