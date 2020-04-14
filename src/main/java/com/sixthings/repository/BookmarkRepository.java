package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Bookmark;
 
@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Long>{
 
}
