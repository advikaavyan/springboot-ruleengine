package com.example.advikaavyan.adaptor.dao;

import com.example.advikaavyan.adaptor.entity.IncomingMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomingMessageRepository extends JpaRepository<IncomingMessage, Long> {
}
