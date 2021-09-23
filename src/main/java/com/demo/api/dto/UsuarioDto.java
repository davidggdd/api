package com.vitesia.api.dto;

public class UsuarioDto {

    private Integer id;
    private String userName;
    private String password;
    private String role;

    public Integer getId () {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName (){
        return this.userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getPassword () {
        return this.password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getRole () {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    
}
