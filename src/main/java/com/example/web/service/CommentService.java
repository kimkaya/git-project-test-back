package com.example.web.service;

import com.example.web.entity.Comment;
import com.example.web.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void writeComment(Comment comment) throws Exception {
        commentRepository.save(comment);
    }
}

