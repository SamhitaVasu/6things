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

import com.sixthings.model.Folder;
import com.sixthings.model.Notebook;
import com.sixthings.model.User;
import com.sixthings.service.NotebookService;
 
@RestController  
public class NotebookController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    NotebookService service;
    
    @PostMapping(value= "/notebook")
    public Long save(final @RequestBody @Valid Notebook notebook) {
        log.info("Saving notebook details in the database.");
        service.save(notebook);
        return notebook.getId();
    }
    
    @GetMapping(value= "/notebook", produces= "application/vnd.jcg.api.v1+json")
    public List<Notebook> getAll() {
        log.info("Getting all notebook details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/notebook/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Notebook get(@PathVariable Long id) {
        log.info("Getting notebook details from the database.");
        return service.repository.findById(id).get();
    }
    @GetMapping(value= "/notebook/{id}/collaborators")
    public Set<User> getAccessList(@PathVariable Long id) {
    	return service.repository.findById(id).get().getCollaborators();
    }
    
    @PutMapping(value= "/notebook/{id}/changePrivacy")
    public String setPrivacy(@RequestBody String privacy, @PathVariable Long id) {
    	service.repository.findById(id).get().setPrivacy(privacy);
    	return service.repository.findById(id).get().getPrivacy();
    }
    @PutMapping(value= "/notebook/{id}/changeName")
    public String setName(@RequestBody String name, @PathVariable Long id) {
    	service.repository.findById(id).get().setName(name);
    	return service.repository.findById(id).get().getName();
    }
    @PutMapping(value= "/notebook/{id}/changeDescription")
    public String setDescription(@RequestBody String description, @PathVariable Long id) {
    	service.repository.findById(id).get().setDescription(description);
    	return service.repository.findById(id).get().getDescription();
    }
    @PutMapping(value= "/notebook/{id}/changeFolder")
    public Folder setFolder(@RequestBody Folder folder, @PathVariable Long id) {
    	service.repository.findById(id).get().setFolder(folder);
    	return service.repository.findById(id).get().getFolder();
    }
    @PutMapping(value="/notebook/{id}/addCollaborators")
    public Set<User> addCollaborator(@RequestBody User user, @PathVariable Long id) {
    	service.repository.findById(id).get().addCollaborators(user);
    	return service.repository.findById(id).get().getCollaborators();
    }
    @PutMapping(value="/notebook/{id}/removeCollaborators")
    public Set<User> removeCollaborator(@RequestBody User user, @PathVariable Long id) {
    	service.repository.findById(id).get().removeCollaborators(user);
    	return service.repository.findById(id).get().getCollaborators();
    }
    @DeleteMapping(value= "/notebook/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting notebook");
        service.delete(service.repository.findById(id).get());
    }
}