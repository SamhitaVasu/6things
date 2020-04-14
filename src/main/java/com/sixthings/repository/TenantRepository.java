package com.sixthings.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sixthings.model.Tenant;
 
@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long>{
 
}
