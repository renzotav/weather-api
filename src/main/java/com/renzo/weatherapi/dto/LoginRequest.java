package com.renzo.weatherapi.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username obrigatório")
    private String username;

    @NotBlank(message = "Senha obrigatória")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
