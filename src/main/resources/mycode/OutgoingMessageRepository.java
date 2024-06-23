package com.example.advikaavyan.adaptor.mycode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutgoingMessageRepository extends JpaRepository<OutgoingMessage, Long> {
}
