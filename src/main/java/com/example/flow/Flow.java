package com.example.flow;


import com.example.flow.model.base.Message;

public interface Flow {
    void executeMessageFlow(Message message);
}
