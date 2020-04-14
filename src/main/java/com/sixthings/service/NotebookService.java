package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Notebook;
import com.sixthings.repository.NotebookRepository;;
 
@Service
public class NotebookService {
 
    @Autowired
	public NotebookRepository repository;
 
    public void save(final Notebook notebook) {
        repository.save(notebook);
    }
 
    public List<Notebook> getAll() {
        final List<Notebook> notebooks = new ArrayList<>();
        repository.findAll().forEach(notebook -> notebooks.add(notebook));
        return notebooks;
    }
    
    public void delete(final Notebook notebook) {
        repository.delete(notebook);
    }
}