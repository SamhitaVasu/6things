package com.sixthings.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixthings.model.Tenant;
import com.sixthings.repository.TenantRepository;;
 
@Service
public class TenantService {
 
    @Autowired
	public TenantRepository repository;
 
    public void save(final Tenant tenant) {
        repository.save(tenant);
    }
 
    public List<Tenant> getAll() {
        final List<Tenant> tenants = new ArrayList<>();
        repository.findAll().forEach(tenant -> tenants.add(tenant));
        return tenants;
    }
}