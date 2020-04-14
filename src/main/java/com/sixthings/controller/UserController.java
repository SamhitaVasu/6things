package com.sixthings.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixthings.model.Bookmark;
import com.sixthings.model.Folder;
import com.sixthings.model.Following;
import com.sixthings.model.Notebook;
import com.sixthings.model.Tenant;
import com.sixthings.model.User;
import com.sixthings.service.UserService;
 
@RestController
public class UserController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
    
    @Autowired
    UserService service;
    
    @PostMapping(value= "/user")
    public Long save(final @RequestBody @Valid User user) {
        log.info("User Controller POST method");
    	service.save(user);
        return user.getId();
    }
    
    @GetMapping(value= "/user", produces= "application/json")
    public List<User> getAll() {
        log.info("User Controller Get ALL method");
    	return service.getAll();
    }
    
    @GetMapping(value= "/user/{id}", produces= "application/json")
    public User get(@PathVariable Long id) {
    	return service.repository.findById(id).get();
    }
    
    @GetMapping(value= "/user/email/{email}", produces= "application/json")
    public User getByEmail(@PathVariable String email) {
    	for(User u : service.getAll()) {
    		System.out.println(u.getEmail());
    		System.out.println(email);
    		if(u.getEmail().contentEquals(email)) {
    			return u;
    		}
    	}
        return null;
    }

    @GetMapping(value= "/user/{id}/followings")
    public Set<Following> getFollowings(@PathVariable Long id) {
    	return service.repository.findById(id).get().getFollowings();
    }
    
    @GetMapping(value= "/user/{id}/bookmarks")
    public Set<Bookmark> getBookmarks(@PathVariable Long id) {
    	return service.repository.findById(id).get().getBookmarks();
    }
    
    @PutMapping(value= "/user/{id}/changeName")
    public User setName(@RequestBody String name, @PathVariable Long id) {
    	User user = service.repository.findById(id).get();
    	user.setName(name);
    	final User updatedUser = service.repository.save(user);
    	return updatedUser;
    }
    
    @PutMapping(value= "/user/{id}/changeTenant")
    public User setTenant(@RequestBody Tenant tenant, @PathVariable Long id) {
    	User user = service.repository.findById(id).get();
    	user.setTenant(tenant);
    	final User updatedUser = service.repository.save(user);
    	return updatedUser;
    }
}