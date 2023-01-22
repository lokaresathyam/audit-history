package com.sathyam.auditlogproducer.controller;

import com.sathyam.auditloglibs.model.Post;
import com.sathyam.auditlogproducer.exception.ResourceNotFoundException;
import com.sathyam.auditlogproducer.request.PostCreateUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/posts")
public interface IPostController {

    @GetMapping
    List<Post> getAllPost();

    @PostMapping
    Post savePost(@RequestBody PostCreateUpdateRequest postCreateUpdateRequest);

    @PutMapping("/{postId}")
    Post updatePost(@PathVariable("postId") String postId, @RequestBody PostCreateUpdateRequest postCreateUpdateRequest) throws ResourceNotFoundException;

    @DeleteMapping("/{postId}")
    String deletePost(@PathVariable("postId") String postId);
}
