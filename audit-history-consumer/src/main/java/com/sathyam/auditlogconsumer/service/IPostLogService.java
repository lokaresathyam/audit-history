package com.sathyam.auditlogconsumer.service;

import com.sathyam.auditloglibs.dto.PostEventDto;

public interface IPostLogService {
    // TODO save old and new objects in log
    void savePostLog(PostEventDto postEventDto);
}
