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
public class Tag {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tag_id;
	
	@NotNull(message = "tag required")
    private String tag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    
    public Tag() {
    	
    }

    public Tag(String tag, Item item) {
    	this.tag = tag;
    	this.item = item;
    }
    
    public Item getItem() {
    	return item;
    }
    
    public Long getId() {
    	return tag_id;
    }
    public String getTag() {
    	return tag;
    }
}
