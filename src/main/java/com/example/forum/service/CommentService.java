package com.example.forum.service;

import com.example.forum.dao.CommentMapper;
import com.example.forum.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public List<Comment> getComment(int foodId) {
        return commentMapper.getComment(foodId);
    }
}
