package com.sixthings.controller;

import java.util.List;

import javax.validation.Valid;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixthings.model.Comment;
import com.sixthings.service.CommentService;
 
@RestController     
public class CommentController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    CommentService service;
    
    @PostMapping(value= "/comment")
    public Long save(final @RequestBody @Valid Comment comment) {
        log.info("Saving comment details in the database.");
        service.save(comment);
        return comment.getId();
    }
    
    @GetMapping(value= "/comment", produces= "application/vnd.jcg.api.v1+json")
    public List<Comment> getAll() {
        log.info("Getting comment details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/comment/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Comment get(@PathVariable Long id) {
        log.info("Getting item details from the database.");
        return service.repository.findById(id).get();
    }
    
    @PutMapping(value= "/comment/{id}/changeBody")
    public String changeBody(@RequestBody String body, @PathVariable Long id) {
    	service.repository.findById(id).get().setBody(body);
    	return service.repository.findById(id).get().getBody();
    }
    @DeleteMapping(value= "/comment/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting comment");
        service.delete(service.repository.findById(id).get());
    }
}