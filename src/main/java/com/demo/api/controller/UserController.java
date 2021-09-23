package com.demo.api.controller;

import com.demo.api.dto.UserDto;
import com.demo.api.dto.UserUpdatePasswordDto;
import com.demo.api.model.User;
import com.demo.api.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    UserService userRest;

    @Autowired
    private PasswordEncoder passwordEncoder;


	// CREAR USUARIO
	@PostMapping(value = "/createUser")
	public User createUser (@RequestBody UserDto usuario) {
	
		User result = new User();
	
		try {
					
			if (log.isInfoEnabled()) {
				log.info("Creando un usuario con userName {}", usuario.getUserName());
			}

            String encriptada = passwordEncoder.encode(usuario.getPassword());

            usuario.setPassword(encriptada);
					
			result = userRest.save(usuario);
		
					
					
		} catch (Exception e) {
			log.error("ERROR", e);
		}
		return result;
	}



    // CAMBIO DE PWD
    @PostMapping(value = "/chgPwdUser")
	public User chgPwdUser (@RequestBody UserUpdatePasswordDto usuario) {
	
	 	User result = new User();
	
	 	try {
					
	 		if (log.isInfoEnabled()) {
	 			log.info("Cambiando la pwd del usuario {}", usuario.getEmail());
	 		}

            String encriptada = passwordEncoder.encode(usuario.getPassword());
			log.info("Cambiando la pwd del usuario {}", encriptada);		
	 		result = userRest.chgPwd(usuario, encriptada);
					
	 	} catch (Exception e) {
	 		log.error("ERROR", e);
	 	}
	 	return result;
	}




	//BORRADO LOGICO DE UN CLIENTE POR ID
    @PostMapping("/deleteUser")
    public void deleteUser( Integer id){
        userRest.delete(id);
    }





    





 
    
}
