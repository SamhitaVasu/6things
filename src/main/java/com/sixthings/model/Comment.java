package com.sixthings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Comment {
	
	@Id
	@Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
	
	@NotNull(message = "comment body required")
	private String body;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public Comment() {
    }
    
    public Comment(User user, String body, Item item) {
    	this.user = user;
    	this.body = body;
    	this.item = item;
    }
    
    public Item getItem() {
    	return item;
    }
    
    public Long getId() {
    	return comment_id;
    }
    public String getBody() {
    	return body;
    }
    public void setBody(String body) {
    	this.body = body;
    }

	public User getUser() {
		return this.user;
	}
    
}
