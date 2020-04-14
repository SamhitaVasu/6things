package com.sixthings.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Tenant {
	
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenant_id;
	
	private boolean  active;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;
    
    public Tenant() {
    	
    }
    
    public Set<User> getUsers() {
    	return users;
    }
    
    public Long getId() {
    	return tenant_id;
    }
    
    public boolean setStatus(boolean active) {
    	this.active = active;
    	return this.active;
    }
    
    public boolean getStatus() {
    	return active;
    }
   
}
