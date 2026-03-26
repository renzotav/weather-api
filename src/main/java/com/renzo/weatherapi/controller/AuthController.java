package com.renzo.weatherapi.controller;

import com.renzo.weatherapi.dto.LoginRequest;
import com.renzo.weatherapi.dto.LoginResponse;
import com.renzo.weatherapi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    public final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        String token = authService.login(request);
        return new LoginResponse(token);
    }
}
