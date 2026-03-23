package com.renzo.weatherapi.service;

import com.renzo.weatherapi.dto.UsuarioRequest;
import com.renzo.weatherapi.model.Usuario;
import com.renzo.weatherapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrarUsuario(UsuarioRequest request){
        Usuario usuario = new Usuario(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword())
        );
        usuarioRepository.save(usuario);
    }
}
