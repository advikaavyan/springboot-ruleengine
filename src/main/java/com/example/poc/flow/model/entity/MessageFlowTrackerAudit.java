package com.example.poc.flow.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGE_FLOW_TRACKER_AUDIT")
@Data
public class MessageFlowTrackerAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_FLOW_TRACKER_AUDIT_ID")
    private Long messageFlowTrackerAuditId;


    @Column(name = "MESSAGE_FLOW_TRACKER_ID")
    private Long messageFlowTrackerId;
    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID", nullable = false)
    private InboundMessage inboundMessage;
    @Column(name = "LEG_TYPE")
    private String legType;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SUB_STATUS")
    private String subStatus;
    @Column(name = "SCHEDULE_RELEASE_AT")
    private LocalDateTime scheduleReleaseAt;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "IN_FLIGHT")
    private Boolean inFlight;
    @Column(name = "IN_FLIGHT_EXPIRED_AT")
    private LocalDateTime inFlightExpiredAt;


}
