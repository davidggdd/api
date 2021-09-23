package com.vitesia.api.repository;

import com.vitesia.api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<User, Integer> {
    public User findByUserName(String userName);
    public User findByUserNameAndPassword(String userName, String password);
    public org.springframework.security.core.userdetails.User save(org.springframework.security.core.userdetails.User usuario);

}

