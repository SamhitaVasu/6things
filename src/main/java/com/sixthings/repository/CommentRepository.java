package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Comment;
 
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
 
}
