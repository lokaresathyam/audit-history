package com.sathyam.auditlogproducer.controller;

import com.sathyam.auditloglibs.model.Post;
import com.sathyam.auditlogproducer.exception.ResourceNotFoundException;
import com.sathyam.auditlogproducer.request.PostCreateUpdateRequest;
import com.sathyam.auditlogproducer.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostController implements IPostController {
    private final IPostService postService;

    @Autowired
    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @Override
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @Override
    public Post savePost(PostCreateUpdateRequest postCreateUpdateRequest) {
        return postService.savePost(postCreateUpdateRequest);
    }

    @Override
    public Post updatePost(String postId, PostCreateUpdateRequest postCreateUpdateRequest) throws ResourceNotFoundException {
        return postService.updatePost(postId, postCreateUpdateRequest);
    }

    @Override
    public String deletePost(String postId) {
        postService.deletePost(postId);
        return "OK";
    }
}
