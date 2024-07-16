package com.example.poc.flow.dao;

import com.example.poc.flow.model.entity.InboundMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundMessageRepository extends JpaRepository<InboundMessage, Long> {
}
