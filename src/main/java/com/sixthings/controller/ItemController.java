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

import com.sixthings.model.Item;
import com.sixthings.model.Notebook;
import com.sixthings.model.User;
import com.sixthings.service.ItemService;
 
@RestController     // Useful to create the RESTful web services.
public class ItemController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    ItemService service;
    
    @PostMapping(value= "/item")
    public Long save(final @RequestBody @Valid Item item) {
    	log.info("Saving item details in the database.");
        service.save(item);
        return item.getId();
    }
    
    @PostMapping(value= "/item/pull/{id}")
    public Long pull(@RequestBody Notebook notebook, @PathVariable Long id) {
        log.info("Pulling item to new notebook");
        Item item = service.repository.findById(id).get();
        item.setNotebook(notebook);
        service.save(item);
        return item.getId();
    }
    
    @GetMapping(value= "/item", produces= "application/vnd.jcg.api.v1+json")
    public List<Item> getAll() {
        log.info("Getting all item details from the database.");
        return service.getAll();
    }
    
    @GetMapping(value= "/item/{id}", produces= "application/vnd.jcg.api.v1+json")
    public Item get(@PathVariable Long id) {
        log.info("Getting item details from the database.");
        return service.repository.findById(id).get();
    }
    
    @GetMapping(value= "/item/{id}/user", produces= "application/vnd.jcg.api.v1+json")
    public User getUser(@PathVariable Long id) {
        log.info("Getting item details from the database.");
        return service.repository.findById(id).get().getUser();
    }
    
    @PutMapping(value= "/item/{id}/changeOrder")
    public int changeOrder(@RequestBody int pos, @PathVariable Long id) {
    	service.changeOrder(service.repository.findById(id).get(), pos);
    	return service.repository.findById(id).get().getOrder();
    }
    
    @PutMapping(value= "/item/{id}/changeBody")
    public String changeBody(@RequestBody String body, @RequestBody User user, @PathVariable Long id) {
    	if(service.repository.findById(id).get().getUser()==user) {
        	service.repository.findById(id).get().setBody(body);
    	}
    	return service.repository.findById(id).get().getBody();
    }
    
    @PutMapping(value= "/item/{id}/changeNumOfPulls")
    public int setNumOfPulls(@RequestBody int num, @PathVariable Long id) {
    	service.repository.findById(id).get().setNumOfPulls(num);
    	return service.repository.findById(id).get().getNumOfPulls();
    }
    
    @DeleteMapping(value= "/item/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deleting item");
        service.delete(service.repository.findById(id).get());
    }
}