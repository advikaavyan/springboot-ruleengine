package com.example.advikaavyan.adaptor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "Signature")

public class Signature {

    @Id
  /*  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "signature_seq")
    @SequenceGenerator(name = "signature_seq", sequenceName = "signature_seq", allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long signatureId;

    @ManyToOne
    @JoinColumn(name = "Message_ID", nullable = false)
    @JsonBackReference // for testing purpose we should not return whole obejct to caller
    private IncomingMessage incomingMessage;

    private String signatureKey;
    private String signatureValue;
    @Column(name = "createdAt", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;


}
