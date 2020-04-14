package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Following;
import com.sixthings.repository.FollowingRepository;
 
@Service
public class FollowingService {
 
    @Autowired
	public FollowingRepository repository;
 
    public void save(final Following following) {
        repository.save(following);
    }
 
    public List<Following> getAll() {
        final List<Following> followings = new ArrayList<>();
        repository.findAll().forEach(following -> followings.add(following));
        return followings;
    }

    public void delete(final Following following) {
        repository.delete(following);
    }
}