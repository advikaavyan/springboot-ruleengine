package com.example.poc.flow.ser;

import com.example.poc.flow.dao.MatchingSignatureRepository;
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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
