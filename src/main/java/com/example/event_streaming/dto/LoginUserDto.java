package com.example.event_streaming.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDto {

    @NotBlank(message= "username can't be empty")
    private String username;

    @NotBlank(message= "password can't be empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
