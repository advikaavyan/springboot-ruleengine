package com.example.poc.flow.dao;

import com.example.poc.flow.model.entity.OutboundMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboundMessageRepository extends JpaRepository<OutboundMessage, Long> {
}
