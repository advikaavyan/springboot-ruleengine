package com.example.poc.flow.ser;

import com.example.poc.flow.dao.OutboundMessageRepository;
import com.example.poc.flow.model.entity.OutboundMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutboundMessageDaoService {
    @Autowired
    private OutboundMessageRepository repository;

    public List<OutboundMessage> findAll() {
        return repository.findAll();
    }

    public Optional<OutboundMessage> findById(Long id) {
        return repository.findById(id);
    }

    public OutboundMessage save(OutboundMessage message) {
        return repository.save(message);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
