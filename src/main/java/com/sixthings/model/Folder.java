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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "folder")
public class Folder {

	@Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folder_id;
	
	@NotNull(message = "folder name required")
    private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Notebook> notebooks;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
    
    public Folder() {
    	
    }

    public Folder(String name, User user) {
    	this.name = name;
    	this.user = user;
    }
    
    public Set<Notebook> getNotebooks() {
    	return notebooks;
    }
    public User getUser() {
    	return user;
    }
    
    public Long getId() {
    	return folder_id;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
}
