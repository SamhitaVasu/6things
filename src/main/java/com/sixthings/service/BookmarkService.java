package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Bookmark;
import com.sixthings.repository.BookmarkRepository;
 
@Service
public class BookmarkService {
 
    @Autowired
	public BookmarkRepository repository;
 
    public void save(final Bookmark bookmark) {
        repository.save(bookmark);
    }
 
    public List<Bookmark> getAll() {
        final List<Bookmark> bookmarks = new ArrayList<>();
        repository.findAll().forEach(bookmark -> bookmarks.add(bookmark));
        return bookmarks;
    }

    public void delete(final Bookmark bookmark) {
        repository.delete(bookmark);
    }
}