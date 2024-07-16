package com.example.poc.flow.dao;

import com.example.poc.flow.model.entity.MessageFlowTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageFlowTrackerRepository extends JpaRepository<MessageFlowTracker, Long> {
}
