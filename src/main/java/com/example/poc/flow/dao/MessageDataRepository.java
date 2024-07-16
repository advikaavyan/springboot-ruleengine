package com.example.poc.flow.dao;

import com.example.poc.flow.model.entity.MessageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDataRepository extends JpaRepository<MessageData, Long> {
}
