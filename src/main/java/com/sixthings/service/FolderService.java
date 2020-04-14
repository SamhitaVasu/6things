package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Folder;
import com.sixthings.repository.FolderRepository;;
 
@Service
public class FolderService {
 
    @Autowired
	public FolderRepository repository;
 
    public void save(final Folder folder) {
        repository.save(folder);
    }
 
    public List<Folder> getAll() {
        final List<Folder> folders = new ArrayList<>();
        repository.findAll().forEach(folder -> folders.add(folder));
        return folders;
    }

    public void delete(final Folder folder) {
        repository.delete(folder);
    }
}