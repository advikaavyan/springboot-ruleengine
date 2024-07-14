package com.example.flow.model.base.impl;

import com.example.flow.model.base.Message;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder

@Getter
public class MessageImpl<T> implements Message<T> {
    private LocalDateTime receivedAt;
    private T content;

    public MessageImpl(LocalDateTime receivedAt, T content) {
        this.receivedAt = receivedAt;
        this.content = content;
    }

    @Override
    public T getContent() {
        return content;
    }

/*    public static void main(String[] args) {
        // Example usage
        LocalDateTime now = LocalDateTime.now();
        String msgContent = "This is a test message";

        Message<String> message = new MessageImpl<>(now, msgContent);

        System.out.println("Received At: " + message.getReceivedAt());
        System.out.println("Message: " + message.getMessage());
    }*/
}
