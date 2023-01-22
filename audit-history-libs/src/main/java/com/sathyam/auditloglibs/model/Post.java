package com.sathyam.auditloglibs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Post {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private Long createdAt;
    private Long modifiedAt;
}
