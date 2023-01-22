package com.sathyam.auditlogproducer.request;

import lombok.Data;

@Data
public class PostCreateUpdateRequest {
    private String title;
    private String description;
    private Long createdAt;
}
