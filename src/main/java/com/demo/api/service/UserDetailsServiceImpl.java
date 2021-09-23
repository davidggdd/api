package com.demo.api.service;

import com.demo.api.repository.UsersRepository;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



/**
 *
 * @author David
 */
@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final static Integer MAX_NUMBER_ATTEMPS = 1;
   
    private final UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.demo.api.model.User user = usersRepository.findByUserName(username);
        if(user != null) {
           
            return User
                       .withUsername(user.getUserName())
                       .password(user.getPassword())
                       .roles(user.getRole())
                       .build();
        } else {
            return null;
        }
    }
    
}
