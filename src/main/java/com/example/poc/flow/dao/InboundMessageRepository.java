package com.example.poc.flow.dao;

import com.example.poc.flow.model.entity.InboundMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InboundMessageRepository extends JpaRepository<InboundMessage, Long> {

    List<InboundMessage> findByMessageIdentifier(String messageIdentifier);
}
