package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Folder;
 
@Repository
public interface FolderRepository extends CrudRepository<Folder, Long>{
 
}
