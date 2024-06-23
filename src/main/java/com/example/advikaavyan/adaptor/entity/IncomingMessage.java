package com.example.advikaavyan.adaptor.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Incoming_Message")
public class IncomingMessage {

    /*    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incoming_message_seq")
        @SequenceGenerator(name = "incoming_message_seq", sequenceName = "incoming_message_seq", allocationSize = 1)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String messageIdentifier;
    private String source;


    // if no annotation then  java.sql.SQLIntegrityConstraintViolationException: Column 'receivedAt' cannot be null
    // if @Column(nullable = false) then  org.hibernate.PropertyValueException: not-null property references a null or transient value : com.example.advikaavyan.adaptor.entity.IncomingMessage.receivedAt

    // if @Column(name = "receivedAt", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    // worked... but need to check it took java instance time or database time, if database in US and java instance in UK then?


    @Column(name = "receivedAt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp receivedAt;

    private String message;

    @OneToMany(mappedBy = "incomingMessage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Signature> signatures;

    @OneToMany(mappedBy = "incomingMessage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MessageFlowTracker> messageFlowTrackers;

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageIdentifier, source, receivedAt, message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomingMessage that = (IncomingMessage) o;
        return Objects.equals(messageId, that.messageId) &&
                Objects.equals(messageIdentifier, that.messageIdentifier) &&
                Objects.equals(source, that.source) &&
                Objects.equals(receivedAt, that.receivedAt) &&
                Objects.equals(message, that.message);
    }
}
