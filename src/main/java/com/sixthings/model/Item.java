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
public class Item {
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
	
    private String body;
    private int numOfPulls;
    private String itemType;
    private int order;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Tag> tags;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notebook_id", nullable = false)
    private Notebook notebook;
    
    public Item() {
    	
    }

    public Item(int order, String body, String itemType, Notebook notebook, User user) {
    	this.order = order;
    	this.body = body;
    	this.itemType = itemType;
    	this.notebook = notebook;
    	this.user = user;
    }
    
    public Set<Tag> getTags() {
    	return tags;
    }
    public Set<Comment> getComments() {
    	return comments;
    }
    public Notebook getNotebook() {
    	return notebook;
    }
    public void setNotebook(Notebook notebook) {
    	this.notebook = notebook;
    }
    public User getUser() {
    	return user;
    }
    
    public Long getId() {
    	return item_id;
    }
    public String getItemType() {
    	return itemType;
    }
    public int getOrder() {
    	return order;
    }
    public void setOrder(int order) {
    	this.order = order;
    }
    public String getBody() {
    	return body;
    }
    public void setBody(String body) {
    	this.body = body;
    }
    public int getNumOfPulls() {
    	return numOfPulls;
    }
    public void setNumOfPulls(int num) {
    	this.numOfPulls = num;
    }
}
