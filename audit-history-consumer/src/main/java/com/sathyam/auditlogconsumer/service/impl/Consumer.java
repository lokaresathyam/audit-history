package com.sathyam.auditlogconsumer.service.impl;

import com.sathyam.auditloglibs.dto.PostEventDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(PostEventDto message) {

    }
}
