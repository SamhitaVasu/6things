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

import com.sixthings.model.Folder;
import com.sixthings.service.FolderService;
 
@RestController     // Useful to create the RESTful web services.
public class FolderController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    FolderService service;
    
    @PostMapping(value= "/folder")
    public Long save(final @RequestBody @Valid Folder folder) {
        log.info("Saving folder details in the database.");
        service.save(folder);
        return folder.getId();
    }
    
    @GetMapping(value= "/folder", produces= "application/vnd.jcg.api.v1+json")
    public List<Folder> getAll() {
        log.info("Getting all folder details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/folder/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Folder get(@PathVariable Long id) {
        log.info("Getting folder details from the database.");
        return service.repository.findById(id).get();
    }

    @PutMapping(value= "/folder/{id}/changeName")
    public String setName(@RequestBody String name, @PathVariable Long id) {
    	service.repository.findById(id).get().setName(name);
    	return service.repository.findById(id).get().getName();
    }
    
    @DeleteMapping(value= "/folder/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting folder");
        service.delete(service.repository.findById(id).get());
    }
}