package com.sixthings.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class Following {

	@Id
	@Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long following_id;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User user;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notebook_id")
    private Notebook followingNotebook;
    
    public Following() {
    	
    }

    public Following(User user, Notebook notebook) {
    	this.user = user;
    	followingNotebook = notebook;
    }
    public Notebook getFollowing() {
    	return followingNotebook;
    }
    public User getUser() {
    	return user;
    }
    
    
    public Long getId() {
    	return following_id;
    }
}
