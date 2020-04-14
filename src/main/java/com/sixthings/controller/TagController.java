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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixthings.model.Tag;
import com.sixthings.service.TagService;
 
@RestController     // Useful to create the RESTful web services.
public class TagController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    TagService service;
    
    @PostMapping(value= "/tag")
    public Long save(final @RequestBody @Valid Tag tag) {
        log.info("Saving tag details in the database.");
        service.save(tag);
        return tag.getId();
    }
    
    @GetMapping(value= "/tag", produces= "application/vnd.jcg.api.v1+json")
    public List<Tag> getAll() {
        log.info("Getting all tag details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/tag/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Tag get(@PathVariable Long id) {
        log.info("Getting tag details from the database.");
        return service.repository.findById(id).get();
    }
    
    @DeleteMapping(value= "/tag/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting tag");
        service.delete(service.repository.findById(id).get());
    }
}