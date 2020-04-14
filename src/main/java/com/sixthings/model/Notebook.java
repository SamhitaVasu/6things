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

@Entity
public class Notebook {
	
	@Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notebook_id;
	
    private String name;
    private String description;
    private String privacy;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> collaborators;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Bookmark> bookmarks;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Following> followers;
    
    @OneToOne
    private User admn;
    
    public Notebook() {
    }
 
    public Notebook(String name, String description, User admn) {
        this.name = name;
        this.description = description;
        privacy = "PUBLIC";
        folder = new Folder("My Collection", admn);
        this.admn = admn;
    }
    
    public Notebook(String name, String description, Folder folder) {
        this.name = name;
        this.description = description;
        privacy = "PUBLIC";
        this.folder = folder;
        this.admn = folder.getUser();
    }
    
    public Notebook(Long id, String name, String description, String privacy, User admn) {
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        folder = new Folder("My Collection", admn);
        this.admn = admn;
    }
    
    public Notebook(Long id, String name, String description, String privacy, Folder folder) {
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.folder = folder;
        this.admn = folder.getUser();
    }
    
    public Set<Item> getItems() {
    	return items;
    }
    public Folder getFolder() {
    	return folder;
    }
    public void setFolder(Folder folder) {
    	this.folder = folder;
    }
    
    public Long getId() {
    	return notebook_id;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public String getPrivacy() {
    	return privacy;
    }
    public void setPrivacy(String privacy) {
    	if(privacy == "PUBLIC" || privacy == "PRIVATE" || privacy == "ORG" || privacy == "ACCESS_LIST") {
    		this.privacy = privacy;
    	}
    }
    public Set<User> getCollaborators() {
    	return collaborators;
    }
    public void addCollaborators(User user) {
    	collaborators.add(user);
    }
    public void removeCollaborators(User user) {
    	collaborators.remove(user);
    }
}
