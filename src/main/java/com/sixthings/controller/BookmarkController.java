package com.sixthings.controller;

import java.util.List;
import java.util.Set;

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

import com.sixthings.model.Bookmark;
import com.sixthings.model.Notebook;
import com.sixthings.model.User;
import com.sixthings.service.BookmarkService;
 
@RestController    
public class BookmarkController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    BookmarkService service;
    
    @PostMapping(value= "/bookmark")
    public Long save(final @RequestBody @Valid Bookmark bookmark) {
        log.info("Saving bookmark details in the database.");
        service.save(bookmark);
        return bookmark.getId();
    }
    
    @GetMapping(value= "/bookmark", produces= "application/vnd.jcg.api.v1+json")
    public List<Bookmark> getAll() {
        log.info("Getting bookmark details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/bookmark/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Bookmark get(@PathVariable Long id) {
        log.info("Getting bookmark details from the database.");
        return service.repository.findById(id).get();
    }
    @GetMapping(value= "/bookmark/{id}/user", produces= "application/vnd.jcg.api.v1+json")
    public User getUser(@PathVariable Long id) {
        return service.repository.findById(id).get().getUser();
    }
    @GetMapping(value= "/bookmark/{id}/notebook", produces= "application/vnd.jcg.api.v1+json")
    public Notebook getNotebook(@PathVariable Long id) {
        return service.repository.findById(id).get().getBookmarkNotebook();
    }
    @DeleteMapping(value= "/bookmark/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting bookmark");
        service.delete(service.repository.findById(id).get());
    }
}