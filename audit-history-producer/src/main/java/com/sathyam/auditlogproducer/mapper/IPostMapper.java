package com.sathyam.auditlogproducer.mapper;

import com.sathyam.auditloglibs.dto.PostDto;
import com.sathyam.auditloglibs.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Slf4j
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class IPostMapper implements IBaseMapper<PostDto, Post> {
}
