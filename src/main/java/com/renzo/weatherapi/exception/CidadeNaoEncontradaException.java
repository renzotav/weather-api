package com.renzo.weatherapi.exception;

public class CidadeNaoEncontradaException extends RuntimeException {

    public CidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
