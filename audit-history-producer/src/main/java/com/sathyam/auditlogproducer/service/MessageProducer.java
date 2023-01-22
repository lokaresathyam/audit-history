package com.sathyam.auditlogproducer.service;

import com.sathyam.auditloglibs.dto.PostEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, PostEventDto> kafkaTemplate;

    public void sendMessage(PostEventDto postEventDto) {
        Message<PostEventDto> message = MessageBuilder
                .withPayload(postEventDto)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();
        this.kafkaTemplate.send(message);
    }
}
