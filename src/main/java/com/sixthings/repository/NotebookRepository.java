package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Notebook;
 
@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long>{
 
}
