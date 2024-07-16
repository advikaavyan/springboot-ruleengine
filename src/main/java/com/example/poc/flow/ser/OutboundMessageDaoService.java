package com.example.poc.flow.ser;

import com.example.poc.flow.dao.MessageFlowTrackerRepository;
import com.example.poc.flow.dao.OutboundMessageRepository;
import com.example.poc.flow.model.dto.OutboundMessageDTO;
import com.example.poc.flow.model.entity.MessageFlowTracker;
import com.example.poc.flow.model.entity.OutboundMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OutboundMessageDaoService {
    @Autowired
    private OutboundMessageRepository repository;
    @Autowired
    private MessageFlowTrackerRepository messageFlowTrackerRepository;

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

    public List<OutboundMessage> saveAll(List<OutboundMessage> outboundMessages) {
        return repository.saveAll(outboundMessages);
    }

    public List<OutboundMessage> saveOutboundMessages(List<MessageFlowTracker> messageFlowTrackers, List<OutboundMessageDTO> outboundMessageDTOS) {

        List<OutboundMessage> outboundMessages = new ArrayList<>();
       /* for (OutboundMessageDTO outboundMessageDTO : outboundMessageDTOS) {
            outboundMessages.add(outboundMessageMapper.toEntity(outboundMessageDTO, inboundMessage));
        }

        MessageFlowTracker messageFlowTracker = messageFlowTrackerRepository.findById(messageFlowTrackerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid messageFlowTrackerId"));

        List<OutboundMessage> outboundMessages = dtos.stream()
                .map(dto -> toEntity(dto, messageFlowTracker))
                .collect(Collectors.toList());
        return outboundMessageRepository.saveAll(outboundMessages);*/
        return null;
    }
}
