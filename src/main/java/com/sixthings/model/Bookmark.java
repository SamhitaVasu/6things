package com.sixthings.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Bookmark {

	@Id
	@Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmark_id;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;
    
    public Bookmark() {
    	
    }

    public Bookmark(User user, Notebook notebook) {
    	this.user = user;
    	this.notebook = notebook;
    }
    public Notebook getBookmarkNotebook() {
    	return notebook;
    }
    public User getUser() {
    	return user;
    }
    
    
    public Long getId() {
    	return bookmark_id;
    }
}
