package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Following;
 
@Repository
public interface FollowingRepository extends CrudRepository<Following, Long>{
 
}
