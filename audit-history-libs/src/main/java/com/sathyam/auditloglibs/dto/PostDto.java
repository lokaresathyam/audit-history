package com.sathyam.auditloglibs.dto;

import lombok.Data;

@Data
public class PostDto {
    private String id;
    private String title;
    private String description;
    private Long createdAt;
    private Long modifiedAt;
}
