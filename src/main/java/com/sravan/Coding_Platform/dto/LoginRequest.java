package com.sravan.Coding_Platform.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    @Email(message = "Invalid Email format")
    private String email;

    @NotBlank(message = "Password should not be empty")
    private String password;

    public LoginRequest(){}

    public LoginRequest(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

}
