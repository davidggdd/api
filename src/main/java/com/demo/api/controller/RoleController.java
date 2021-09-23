package com.vitesia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.vitesia.api.model.Role;

import com.vitesia.api.service.RoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RoleController {

    private final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    RoleService roleRest;


    // LISTA DE ROLES
    @GetMapping(value = "/roles")
	public List<Role> roles () {
        List<Role> result=new ArrayList<>();
		try {
			
            if (log.isInfoEnabled()) {
                log.info("Listando los roles");
            }
			
			result = roleRest.getAll();

			
			
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return result;
	}


	// BUSCAR ROL POR NOMBRE
	@PostMapping(value = "/rol")
	public Role rol (String roleName) {
		Role result=new Role();
		try {
				
			if (log.isInfoEnabled()) {
				log.info("Buscando el rol " + roleName);
			}
				
			result = roleRest.getByName(roleName);
	
				
				
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return result;
	}


	// BUSCAR ROL POR ID
	@PostMapping(value = "/rolId")
	public Role rol (Long id) {
		Role result=new Role();
		try {
				
			if (log.isInfoEnabled()) {
				log.info("Buscando el rol " + id);
			}
				
			result = roleRest.getById(id);
	
				
				
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return result;
	}

 
    
}
