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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class User {

	@Id
	@Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
	
	@NotNull(message = "email is required")
    private String email;
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Notebook> notebooks;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Folder> folders;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Bookmark> bookmarks;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Following> followings;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
    
    public User() {
    	
    }

    public User(String email) {
    	this.email = email;
    }
    
    public User(String email, Tenant tenant) {
    	this.email = email;
    	this.tenant = tenant;
    }
    
    public Set<Notebook> getNotebooks() {
    	return notebooks;
    }
    public Set<Folder> getFolders() {
    	return folders;
    }
    public Tenant getTenant() {
    	return tenant;
    }
    public void setTenant(Tenant tenant) {
    	this.tenant = tenant;
    }
    public Set<Following> getFollowings() {
    	return followings;
    }
    public Set<Bookmark> getBookmarks() {
    	return bookmarks;
    }
    public Set<Comment> getComments() {
    	return comments;
    }
    
    
    public Long getId() {
    	return user_id;
    }
    public String getEmail() {
    	return email;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
}
