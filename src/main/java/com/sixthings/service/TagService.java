package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Tag;
import com.sixthings.repository.TagRepository;;
 
@Service
public class TagService {
 
    @Autowired
	public TagRepository repository;
 
    public void save(final Tag tag) {
        repository.save(tag);
    }
 
    public List<Tag> getAll() {
        final List<Tag> tags = new ArrayList<>();
        repository.findAll().forEach(tag -> tags.add(tag));
        return tags;
    }
    
    public void delete(Tag tag) {
    	repository.delete(tag);
    }
}