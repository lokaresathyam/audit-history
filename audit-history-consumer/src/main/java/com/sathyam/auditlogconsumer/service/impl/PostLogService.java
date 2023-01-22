package com.sathyam.auditlogconsumer.service.impl;

import com.sathyam.auditlogconsumer.model.PostLog;
import com.sathyam.auditlogconsumer.repository.PostLogRepository;
import com.sathyam.auditlogconsumer.service.IPostLogService;
import com.sathyam.auditloglibs.dto.PostEventDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PostLogService implements IPostLogService {
    private final PostLogRepository postLogRepository;

    // TODO save old and new objects in log
    @Override
    public void savePostLog(PostEventDto postEventDto) {
        PostLog postLog = new PostLog();
        postLog.setPostId(postLog.getPostId());
        postLog.setAction(postLog.getAction());
        postLog.setTriggeredAt(postLog.getTriggeredAt());

        postLogRepository.save(postLog);
    }
}
