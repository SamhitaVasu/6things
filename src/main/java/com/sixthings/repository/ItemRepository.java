package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Item;
 
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
 
}
