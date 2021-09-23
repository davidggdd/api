package com.vitesia.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @JsonProperty("nombre_usuario")
    @Column(name = "user_name")
    @NotNull(message = "El campo nombre_usuario es obligatorio")  
    @NotEmpty(message = "El campo nombre_usuario no puede estar vacío")
    private String userName;
   
    private String password;
   
    @NotNull(message = "El campo estado es obligatorio")  
    @NotEmpty(message = "El campo estado no puede estar vacío")
    @JsonProperty("estado")
    private String status;


    @NotNull(message = "El campo role es obligatorio")  
    @NotEmpty(message = "El campo role no puede estar vacío")
    private String role;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}