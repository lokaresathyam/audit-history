package com.sathyam.auditlogconsumer.model;

import com.sathyam.auditloglibs.dto.Action;
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
public class PostLog {
    @Id
    private ObjectId id;
    private String postId;
    private Action action;
    private Long triggeredAt;
}
