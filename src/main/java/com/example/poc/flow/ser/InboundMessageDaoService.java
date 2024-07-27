package com.example.poc.flow.ser;
import com.example.poc.flow.dao.InboundMessageRepository;
import com.example.poc.flow.model.entity.InboundMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InboundMessageDaoService {
    @Autowired
    private InboundMessageRepository repository;

    public List<InboundMessage> findAll() {
        return repository.findAll();
    }

    public List<InboundMessage> findByMessageIdentifier(String messageIdentifier) {
        return repository.findByMessageIdentifier(messageIdentifier);
    }

    public Optional<InboundMessage> findById(Long id) {
        return repository.findById(id);
    }

    public InboundMessage save(InboundMessage message) {
        return repository.save(message);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
