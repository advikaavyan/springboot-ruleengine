package com.example.poc.flow.ser;

import com.example.poc.flow.dao.MatchingSignatureRepository;
import com.example.poc.flow.model.MatchingKey;
import com.example.poc.flow.model.entity.MatchingSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchingSignatureDaoService {
    @Autowired
    private MatchingSignatureRepository repository;

    public List<MatchingSignature> findAll() {
        return repository.findAll();
    }

    public Optional<MatchingSignature> findById(Long id) {
        return repository.findById(id);
    }

    public MatchingSignature save(MatchingSignature signature) {
        return repository.save(signature);
    }
    public List<MatchingSignature> saveAll(List<MatchingSignature> signatures) {
        return repository.saveAll(signatures);
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<MatchingSignature> findByMatchingKeyAndMatchingValue(String matchingKey, String matchingValue) {
        return repository.findByMatchingKeyAndMatchingValue(matchingKey, matchingValue);
    }

    public List<MatchingSignature> findByMatchingKeysAndMatchingValues(List<MatchingKey> matchingKeys, List<String> matchingValues) {
        return repository.findByMatchingKeyInAndMatchingValueIn(matchingKeys, matchingValues);
    }
}
