package com.renzo.weatherapi.service;

import com.renzo.weatherapi.dto.LoginRequest;
import com.renzo.weatherapi.model.Usuario;
import com.renzo.weatherapi.repository.UsuarioRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }
        public String login(LoginRequest request){


            Usuario usuario = usuarioRepository
                    .findByUsername(request.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

            /*if(!usuario.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Senha invalida");
            }*/
            if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
                throw new BadCredentialsException("Senha inválida");
            }

            return jwtService.gerarToken(usuario.getUsername());

    }
}
