package com.vitesia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.vitesia.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, BaseRepository<Cliente, Integer> {

    public Cliente findByCif(String cif);
}


