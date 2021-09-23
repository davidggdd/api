package com.demo.api.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {
	    
	    @JsonProperty("codigo_error")
	    private String code;
	    
	    @JsonProperty("descripcion")
	    private String description;

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }
	    
	}

