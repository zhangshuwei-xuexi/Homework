package com.example.forum.dao;

import com.example.forum.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addComment(Comment comment);

    List<Comment> getComment(int foodId);
}
