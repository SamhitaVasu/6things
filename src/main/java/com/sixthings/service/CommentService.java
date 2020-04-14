package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Comment;
import com.sixthings.repository.CommentRepository;;
 
@Service
public class CommentService {
 
    @Autowired
	public CommentRepository repository;
 
    public void save(final Comment comment) {
        repository.save(comment);
    }
 
    public List<Comment> getAll() {
        final List<Comment> comments = new ArrayList<>();
        repository.findAll().forEach(comment -> comments.add(comment));
        return comments;
    }

    public void delete(final Comment comment) {
        repository.delete(comment);
    }
}