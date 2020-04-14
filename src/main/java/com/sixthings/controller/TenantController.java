package com.sixthings.controller;

import java.util.List;

import javax.validation.Valid;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixthings.model.Tenant;
import com.sixthings.service.TenantService;
 
@RestController   
public class TenantController {
 
    private final Logger log = LoggerFactory.getLogger(this.getClass()); 
 
    @Autowired
    TenantService service;
 
    @PostMapping(value= "/tenant")
    public Long save(final @RequestBody @Valid Tenant tenant) {
        log.info("Tenant Controller POST method");
        tenant.setStatus(true);
        service.save(tenant);
        return tenant.getId();
    }
 
    @GetMapping(value= "/tenant", produces= "application/json")
    public List<Tenant> getAll() {
        log.info("Tenant Controller Get ALL method");
        return service.getAll();
    }
    
    @GetMapping(value= "/tenant/{id}", produces= "application/json")
    public Tenant get(@PathVariable Long id) {
        log.info("Tenant Controller Get method");
        return service.repository.findById(id).get();
    }
    
    @GetMapping(value= "/tenant/{id}/status", produces= "application/json")
    public boolean getStatus(@PathVariable Long id) {
        return service.repository.findById(id).get().getStatus();
    }
    
    @PutMapping(value= "/tenant/{id}")
    public Tenant deactivate(@PathVariable Long id) {
        log.info("Tenant Controller PUT method");
    	Tenant tenant = service.repository.findById(id).get();
    	tenant.setStatus(false);
    	final Tenant updatedTenant = service.repository.save(tenant);
    	return updatedTenant;
    }
}