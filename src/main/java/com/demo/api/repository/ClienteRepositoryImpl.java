package com.demo.api.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.demo.api.model.Cliente;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClienteRepositoryImpl implements BaseRepository<Cliente, Integer> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Cliente findWithGraph(Integer id, String graphName) {

        EntityGraph entityGraph = entityManager.getEntityGraph(graphName);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Cliente cliente = entityManager.find(Cliente.class, id, properties);

        return cliente;
    }
}
