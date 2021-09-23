package com.vitesia.api.dto;

import javax.validation.constraints.NotEmpty;

public class UserUpdatePasswordDto {

    private String email;
	
	@NotEmpty
	private String oldPassword;

	@NotEmpty
	private String password;

	@NotEmpty
	private String confirmPassword;

    public String getEmail() {
		return email;
	}

	public String getOldPassword(){
        return oldPassword;
    }

	public String getPassword(){
        return password;
    }

    public String getConfirmPassword(){
        return confirmPassword;
    }

    public void setEmail(String email) {
		this.email = email;
	}

	public void setOldPassword(String oldPassword){
        this.oldPassword = oldPassword;
    }

	public void setPassword(String password){
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }

    
}
