package com.example.poc.flow.dao;

import com.example.poc.flow.model.base.MatchingKey;
import com.example.poc.flow.model.entity.MatchingSignature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatchingSignatureRepository extends JpaRepository<MatchingSignature, Long> {
    Optional<MatchingSignature> findByMatchingKeyAndMatchingValue(String matchingKey, String matchingValue);

    @Query("SELECT ms FROM MatchingSignature ms WHERE ms.matchingKey IN :matchingKeys AND ms.matchingValue IN :matchingValues")
    List<MatchingSignature> findByMatchingKeyInAndMatchingValueIn(@Param("matchingKeys") List<MatchingKey> matchingKeys, @Param("matchingValues") List<String> matchingValues);

/*    @Query("SELECT ms FROM MatchingSignature ms " +
            "JOIN FETCH ms.inboundMessage im " +
            "JOIN FETCH im.messageFlowTracker " +
            "WHERE ms.matchingKey IN :matchingKeys " +
            "AND ms.matchingValue IN :matchingValues")
    List<MatchingSignature> findByMatchingKeyInAndMatchingValueIn(@Param("matchingKeys") List<MatchingKey> matchingKeys, @Param("matchingValues") List<String> matchingValues);*/

}
