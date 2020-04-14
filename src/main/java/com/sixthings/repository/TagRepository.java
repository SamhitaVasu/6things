package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Tag;
 
@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
 
}
