package com.sathyam.auditlogproducer.events;

import com.sathyam.auditloglibs.dto.PostEventDto;
import com.sathyam.auditlogproducer.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class PostEventListener {
    @Autowired
    private MessageProducer messageProducer;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleNewIndexCommand(PostEventDto postEventDto) {
        messageProducer.sendMessage(postEventDto);
    }

}
