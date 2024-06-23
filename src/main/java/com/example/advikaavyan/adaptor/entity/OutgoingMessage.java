package com.example.advikaavyan.adaptor.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "Outgoing_Message")
public class OutgoingMessage {

    @Id
  /*  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outgoing_message_seq")
    @SequenceGenerator(name = "outgoing_message_seq", sequenceName = "outgoing_message_seq", allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outgoingMessageId;

  /*  @ManyToOne
    @JoinColumn(name = "Message_Flow_Tracker_ID", nullable = false)
    private MessageFlowTracker messageFlowTracker;*/
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Message_Flow_Tracker_ID", unique = true, nullable = false)
    private MessageFlowTracker messageFlowTracker;

    private String legType;
    @Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")

    private Timestamp createdAt;
    private String outgoingMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutgoingMessage that = (OutgoingMessage) o;
        return  Objects.equals(messageFlowTracker, that.messageFlowTracker) && Objects.equals(legType, that.legType) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( messageFlowTracker, legType);
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutgoingMessage outGoing = (OutgoingMessage) o;
        return Objects.equals(outgoingMessageId, outGoing.outgoingMessageId);  // Use ID for equality comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(outgoingMessageId);  // Use ID for hash code calculation
    }*/
}
