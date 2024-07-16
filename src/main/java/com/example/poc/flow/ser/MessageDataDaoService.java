package com.example.poc.flow.ser;

import com.example.poc.flow.dao.MessageDataRepository;
import com.example.poc.flow.model.entity.MessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageDataDaoService {
    @Autowired
    private MessageDataRepository repository;

    public List<MessageData> findAll() {
        return repository.findAll();
    }

    public Optional<MessageData> findById(Long id) {
        return repository.findById(id);
    }

    public MessageData save(MessageData data) {
        return repository.save(data);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
