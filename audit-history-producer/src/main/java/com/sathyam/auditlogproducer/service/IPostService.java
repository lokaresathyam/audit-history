package com.sathyam.auditlogproducer.service;

import com.sathyam.auditloglibs.model.Post;
import com.sathyam.auditlogproducer.exception.ResourceNotFoundException;
import com.sathyam.auditlogproducer.request.PostCreateUpdateRequest;

import java.util.List;

public interface IPostService {
    List<Post> getAllPost();

    Post savePost(PostCreateUpdateRequest postCreateUpdateRequest);

    Post updatePost(String id, PostCreateUpdateRequest postCreateUpdateRequest) throws ResourceNotFoundException;

    void deletePost(String id);
}
