package com.example.advikaavyan.adaptor.mycode;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
    List<Signature> findByKeyAndValue(String key, String value);
}
