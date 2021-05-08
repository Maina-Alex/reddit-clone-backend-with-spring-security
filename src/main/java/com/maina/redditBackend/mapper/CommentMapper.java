package com.maina.redditBackend.mapper;

import com.maina.redditBackend.dto.CommentsDto;
import com.maina.redditBackend.model.Comment;
import com.maina.redditBackend.model.Post;
import com.maina.redditBackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target ="text", source = "CommentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target="post", source="post")
    @Mapping(target="user",source="user")
    Comment map (CommentsDto commentDto, Post post, User user);

    @Mapping(target="postId",expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comment comment);


}
