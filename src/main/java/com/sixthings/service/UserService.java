package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.User;
import com.sixthings.repository.TenantRepository;
import com.sixthings.repository.UserRepository;;
 
@Service
public class UserService {
 
    @Autowired
	public UserRepository repository;
 
    public void save(final User user) {
        repository.save(user);
    }
 
    public List<User> getAll() {
        final List<User> users = new ArrayList<>();
        repository.findAll().forEach(user -> users.add(user));
        return users;
    }
}