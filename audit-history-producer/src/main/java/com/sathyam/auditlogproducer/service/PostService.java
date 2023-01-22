package com.sathyam.auditlogproducer.service;


import com.sathyam.auditloglibs.dto.Action;
import com.sathyam.auditloglibs.dto.PostEventDto;
import com.sathyam.auditloglibs.model.Post;
import com.sathyam.auditlogproducer.exception.ResourceNotFoundException;
import com.sathyam.auditlogproducer.repository.PostRepository;
import com.sathyam.auditlogproducer.request.PostCreateUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    @TransactionalEventListener
    public Post savePost(PostCreateUpdateRequest postCreateUpdateRequest) {
        Post post = new Post();

        Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        post.setId(new ObjectId());
        post.setDescription(postCreateUpdateRequest.getDescription());
        post.setTitle(postCreateUpdateRequest.getTitle());
        post.setCreatedAt(time);
        post.setModifiedAt(time);
        postRepository.save(post);

        PostEventDto postEventDto = new PostEventDto();
        postEventDto.setPostId(post.getId().toString());
        postEventDto.setAction(Action.CREATE);
        postEventDto.setTriggeredAt(time);

        applicationEventPublisher.publishEvent(postEventDto);
        return post;
    }

    @Override
    public Post updatePost(String id, PostCreateUpdateRequest postCreateUpdateRequest) throws ResourceNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        if (!ObjectUtils.isEmpty(postCreateUpdateRequest.getDescription())) {
            post.setDescription(postCreateUpdateRequest.getDescription());
        }
        if (!ObjectUtils.isEmpty(postCreateUpdateRequest.getTitle())) {
            post.setDescription(postCreateUpdateRequest.getTitle());
        }
        Long time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        post.setModifiedAt(time);

        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }
}
