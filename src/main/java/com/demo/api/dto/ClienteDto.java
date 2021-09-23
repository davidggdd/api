package com.demo.api.dto;

public class ClienteDto {

    private static final long serialVersionUID = 1L;
    
    private String email;
    
    private String name;
    
    private String cif;    
    
	private String direccion;
    
	private String poblacion;  
    
	private String telefono; 
    
	private String latitud;
    
	private String longitud;


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

    
}
