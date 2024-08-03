package com.example.advikaavyan.adaptor.mycode;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "INCOMING_MESSAGE")
@Data
public class IncomingMessage {
/*    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incoming_message_seq")
    @SequenceGenerator(name = "incoming_message_seq", sequenceName = "incoming_message_seq", allocationSize = 1)
    private Long messageId;*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incoming_message_seq")
    @SequenceGenerator(name = "incoming_message_seq", sequenceName = "incoming_message_seq", allocationSize = 1)
    @Column(name = "MESSAGE_ID")
    private Long messageId;
   /* @Column(nullable = false, unique = true)
    private String messageIdentifier;*/

    @Column(name = "MESSAGE_IDENTIFIER", nullable = false)  // Ensure nullable = false if it cannot be null
    private String messageIdentifier;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private LocalDateTime receivedAt;

    @Column(nullable = false)
    private String message;

    @OneToMany(mappedBy = "incomingMessage")
    private List<Signature> signatures;

    @OneToMany(mappedBy = "incomingMessage")
    private List<MessageFlowTracker> messageFlowTrackers;
}
