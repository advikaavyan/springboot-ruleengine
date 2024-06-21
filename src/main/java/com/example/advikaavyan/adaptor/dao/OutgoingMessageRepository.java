package com.example.advikaavyan.adaptor.dao;

import com.example.advikaavyan.adaptor.entity.OutgoingMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OutgoingMessageRepository extends JpaRepository<OutgoingMessage, Long> {
}
