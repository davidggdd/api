package com.demo.api.repository;

import com.demo.api.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, BaseRepository<Cliente, Integer> {

    public Cliente findByCif(String cif);
}


