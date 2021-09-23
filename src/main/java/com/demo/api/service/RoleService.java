package com.vitesia.api.service;

import java.util.List;

import com.vitesia.api.model.Role;
import com.vitesia.api.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



/**
 *
 * @author Vitesia
 */
@Primary
@Service
public class RoleService 
{

    @Autowired
    private RoleRepository roleRepository;


    public Role getByName(String name) {
        Role rol = roleRepository.findByRoleName(name);
        if (rol != null) {

            return rol;
        } else {
            return null;
        }
    }


    public Role getById(Long idRol) {
        Role rol = roleRepository.findById(idRol).orElse(null);
        if (rol != null) {

            return rol;
        } else {
            return null;
        }
    }


    public List<Role> getAll() {
        List<Role> roles = roleRepository.findAll();
        if (roles != null) {
            return roles;
        } else {
            return null;
        }
    }
    
}
