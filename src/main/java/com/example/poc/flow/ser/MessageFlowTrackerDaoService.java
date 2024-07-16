package com.example.poc.flow.ser;

import com.example.poc.flow.dao.MessageFlowTrackerRepository;
import com.example.poc.flow.model.entity.MessageFlowTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageFlowTrackerDaoService {
    @Autowired
    private MessageFlowTrackerRepository repository;

    public List<MessageFlowTracker> findAll() {
        return repository.findAll();
    }

    public Optional<MessageFlowTracker> findById(Long id) {
        return repository.findById(id);
    }

    public MessageFlowTracker save(MessageFlowTracker tracker) {
        return repository.save(tracker);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
