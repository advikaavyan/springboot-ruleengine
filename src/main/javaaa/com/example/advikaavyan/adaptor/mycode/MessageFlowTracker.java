package com.example.advikaavyan.adaptor.mycode;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MESSAGE_FLOW_TRACKER")
@Data
public class MessageFlowTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_flow_tracker_seq")
    @SequenceGenerator(name = "message_flow_tracker_seq", sequenceName = "message_flow_tracker_seq", allocationSize = 1)
    private Long messageFlowTrackerId;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private IncomingMessage incomingMessage;

    @Column(nullable = false)
    private String legType;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String subStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean inFlight;

    @OneToMany(mappedBy = "messageFlowTracker")
    private List<OutgoingMessage> outgoingMessages;
}
