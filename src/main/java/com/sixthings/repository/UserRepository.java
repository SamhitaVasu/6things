package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.User;
 
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
 
}
