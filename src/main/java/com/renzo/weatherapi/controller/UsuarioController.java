package com.renzo.weatherapi.controller;


import com.renzo.weatherapi.dto.UsuarioRequest;
import com.renzo.weatherapi.model.Usuario;
import com.renzo.weatherapi.response.ApiResponse;
import com.renzo.weatherapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ApiResponse<String> cadastrar(@RequestBody @Valid UsuarioRequest request){
        usuarioService.cadastrarUsuario(request);

        return new ApiResponse<>(true, "Usuario cadastrado com sucesso", null);
    }

    @GetMapping
    public ApiResponse<List<Usuario>> listar(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return new ApiResponse<>(true, usuarios, null);
    }
}
