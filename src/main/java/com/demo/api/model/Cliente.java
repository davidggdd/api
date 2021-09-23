package com.vitesia.api.model;

import java.util.List;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "clientes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    
    @JsonProperty("email_cliente")
    @Column(name = "email")
    @NotNull(message = "El campo email_cliente es obligatorio")  
    @NotEmpty(message = "El campo email_cliente no puede estar vacío")
    private String email;
    
    @JsonProperty("nombre_cliente")
    @Column(name = "name")
    @NotNull(message = "El campo nombre_cliente es obligatorio")  
    @NotEmpty(message = "El campo nombre_cliente no puede estar vacío")
    private String name;
    
    @JsonProperty("cif_cliente")
    @Column(name = "cif")
    @NotNull(message = "El campo cif_cliente es obligatorio")  
    @NotEmpty(message = "El campo cif_cliente no puede estar vacío")
    private String cif;    
    
    @Column(name="direccion")
	private String direccion;
    
    @Column(name="poblacion")
	private String poblacion;  
    
    @Column(name="telefono")  
	private String telefono; 
    
    @Column(name="latitud")
	private String latitud;
    
    @Column(name="longitud")
	private String longitud;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_cliente", joinColumns
            = @JoinColumn(name = "cliente_id",
            referencedColumnName = "idcliente"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"))
    private List<User> usuarios;
 
    public Integer getIdcliente() {
        return idcliente;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


    public String getDireccion() {
        return direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getCif() {
        return cif;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }



    public void setIdcliente(Integer id) {
        this.idcliente = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setTelefono(String telefono) {
        this.telefono =  telefono;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
   
    public void setCif(String cif) {
        this.cif = cif;
    }



    public void setUsuarios(List<User> listaUsuarios) {
        this.usuarios = listaUsuarios;
    }
    
}
