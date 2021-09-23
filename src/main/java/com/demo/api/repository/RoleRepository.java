package com.demo.api.repository;

import com.demo.api.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository 
    extends JpaRepository<Role, Long> 
    {
     public Role findByRoleName(String name);
    
}

