package com.vitesia.api.dto;

import java.io.Serializable;




public class ClienteComboDto implements Serializable {

    private Integer idCliente;
    private String name;


 
    public Integer getIdCliente() {
        return idCliente;
    }

    public String getName() {
        return name;
    }

    public void setIdCliente(Integer id) {
        this.idCliente = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}