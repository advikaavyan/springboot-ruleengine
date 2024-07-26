package com.example.advikaavyan.adaptor.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "Message_Flow_Tracker")
public class MessageFlowTracker {

    @Id
  /*  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_flow_tracker_seq")
    @SequenceGenerator(name = "message_flow_tracker_seq", sequenceName = "message_flow_tracker_seq", allocationSize = 1)*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long messageFlowTrackerId;

    @ManyToOne
    @JoinColumn(name = "Message_ID", nullable = false)
    @JsonBackReference // for testing purpose we should not return whole obejct to caller
    private IncomingMessage incomingMessage;



    private String legType;
    private String status;
    private String subStatus;

    @Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    private Boolean inFlight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFlowTracker that = (MessageFlowTracker) o;
        return legType.equals(that.legType) && status.equals(that.status) && subStatus.equals(that.subStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legType, status, subStatus);
    }
/* @OneToMany(mappedBy = "messageFlowTracker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OutgoingMessage> outgoingMessages;*/

    @OneToOne(mappedBy = "messageFlowTracker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    private OutgoingMessage outgoingMessage;

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFlowTracker that = (MessageFlowTracker) o;
        return Objects.equals(messageFlowTrackerId, that.messageFlowTrackerId);  // Use ID for equality comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageFlowTrackerId);  // Use ID for hash code calculation
    }*/
}
