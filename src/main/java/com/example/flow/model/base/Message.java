package com.example.flow.model.base;

import java.time.LocalDateTime;

public interface Message<T> {
    LocalDateTime getReceivedAt();
    T getContent();
}
