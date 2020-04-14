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

import com.sixthings.model.Following;
import com.sixthings.model.Notebook;
import com.sixthings.model.User;
import com.sixthings.service.FollowingService;
 
@RestController    
public class FollowingController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    FollowingService service;
    
    @PostMapping(value= "/following")
    public Long save(final @RequestBody @Valid Following following) {
        log.info("Saving following details in the database.");
        service.save(following);
        return following.getId();
    }
    
    @GetMapping(value= "/following", produces= "application/vnd.jcg.api.v1+json")
    public List<Following> getAll() {
        log.info("Getting following details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/following/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Following get(@PathVariable Long id) {
        log.info("Getting following details from the database for a specific user w/following id.");
        return service.repository.findById(id).get();
    }
    @GetMapping(value= "/following/{id}/user", produces= "application/vnd.jcg.api.v1+json")
    public User getUser(@PathVariable Long id) {
        return service.repository.findById(id).get().getUser();
    }
    
    @DeleteMapping(value= "/following/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting following");
        service.delete(service.repository.findById(id).get());
    }
}