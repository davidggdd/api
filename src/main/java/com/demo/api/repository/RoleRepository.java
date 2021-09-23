package com.vitesia.api.repository;

import com.vitesia.api.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository 
    extends JpaRepository<Role, Long> 
    {
     public Role findByRoleName(String name);
    
}

