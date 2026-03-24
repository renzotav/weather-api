package com.renzo.weatherapi.exception;

import com.renzo.weatherapi.dto.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> handleRuntimeException(RuntimeException e) {
        ErroResponse erro = new ErroResponse(404, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleException(Exception e) {
        ErroResponse erro = new ErroResponse(500, "Erro interno no servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(UsernameNotFoundException.class) //
    public ResponseEntity<ErroResponse> handleUsernameNotFoundException(UsernameNotFoundException e) {
        ErroResponse erro = new ErroResponse(404, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(BadCredentialsException.class) //
    public ResponseEntity<ErroResponse> handleBadCredentialsException(BadCredentialsException e) {
        ErroResponse erro = new ErroResponse(401, "Senha inválida");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleValidationException(MethodArgumentNotValidException e) {
        String mensagem = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> field.getField() + ": " + field.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErroResponse erro = new ErroResponse(400, mensagem);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}