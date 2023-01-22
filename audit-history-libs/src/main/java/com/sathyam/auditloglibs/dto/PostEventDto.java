package com.sathyam.auditloglibs.dto;

import lombok.Data;

@Data
public class PostEventDto {
    private String postId;
    private Action action;
    private Long triggeredAt;
}
