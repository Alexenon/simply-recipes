package com.xenon.simplyrecipes.services;

import com.xenon.simplyrecipes.entities.Comment;
import com.xenon.simplyrecipes.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> addComments(List<Comment> comments) {
        return commentRepository.saveAll(comments);
    }

}
