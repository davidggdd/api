package com.vitesia.api.service;

import com.vitesia.api.dto.UserDto;
import com.vitesia.api.dto.UserUpdatePasswordDto;
import com.vitesia.api.model.User;
import com.vitesia.api.repository.UsersRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vitesia
 */
@Primary
@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    

    @Autowired
    private UsersRepository usersRepository;

    

    public User save(UserDto usuarioDto) {
        
        try {
					
			if (log.isInfoEnabled()) {
				log.info("Creando un usuario con userName " + usuarioDto.getUserName());
			}
        
            com.vitesia.api.model.User user = usersRepository.findByUserName(usuarioDto.getUserName());
        
        
            if (!(user != null)) {
           
                User usuario = new User();
                usuario.setPassword(usuarioDto.getPassword());
                usuario.setRole(usuarioDto.getRole());
                usuario.setStatus(usuarioDto.getStatus());
                usuario.setUserName(usuarioDto.getUserName());
                usuario = usersRepository.save(usuario);

                return usuario;

            } else {
                return null;
            }
        } catch (Exception e) {
			log.error("ERROR", e);
		}
		return null;    
    }


    public User chgPwd(UserUpdatePasswordDto user, String pwd) {
        
        User usuario=usersRepository.findByUserName(user.getEmail());
        
		usuario.setPassword(pwd);
        log.info("Creando un usuario con userName " + usuario.getUserName());
        
		return usersRepository.save(usuario);
    }

    public void delete(Integer id) {
        
        User usuario=usersRepository.findById(id).orElse(null);

        if (usuario != null) {
        
		    usuario.setStatus("deleted");
        
		    usersRepository.save(usuario);
        }
    }

    
}
