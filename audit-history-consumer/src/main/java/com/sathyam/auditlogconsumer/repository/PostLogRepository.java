package com.sathyam.auditlogconsumer.repository;

import com.sathyam.auditlogconsumer.model.PostLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLogRepository extends MongoRepository<PostLog, String> {

}
