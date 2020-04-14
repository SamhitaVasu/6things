package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Item;
import com.sixthings.repository.ItemRepository;

@Service
public class ItemService {
 
    @Autowired
	public ItemRepository repository;
 
    public void save(final Item item) {
        repository.save(item);
    }
 
    public List<Item> getAll() {
        final List<Item> items = new ArrayList<>();
        repository.findAll().forEach(item -> items.add(item));
        return items;
    }
    
    public void changeOrder(Item item, int pos) {
    	List<Item> items = (List<Item>) repository.findAll();
    	if (pos < item.getOrder()) {
    		for(Item i : items) {
        		if(i.getNotebook()==item.getNotebook()) {
        			if(i.getOrder()>=pos && i.getOrder()<item.getOrder()) {
        				repository.findById(i.getId()).get().setOrder(i.getOrder()+1);
        			}
        			else if(i.getOrder()==item.getOrder()) {
        				repository.findById(item.getId()).get().setOrder(pos);
        			}
        		}
        	}
    	}
    	else if (pos > item.getOrder()) {
    		for(Item i : items) {
        		if(i.getNotebook()==item.getNotebook()) {
        			if(i.getOrder()<=pos && i.getOrder()>item.getOrder()) {
        				repository.findById(i.getId()).get().setOrder(i.getOrder()-1);
        			}
        			if(i.getOrder()==item.getOrder()) {
        				repository.findById(item.getId()).get().setOrder(pos);
        			}
        		}
        	}
    	}
    }
    
    public void delete(final Item item) {
        repository.delete(item);
    }
}