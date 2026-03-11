package com.renzo.weatherapi.service;

import org.springframework.stereotype.Service;

@Service
public class ClimaService {

    public String consultarClima(String cidade){
        return "Consultando clima da cidade: " + cidade;
    }

    public String consultarTemperatura(String cidade){
        return "A temperatura em " + cidade + " é de x graus";
    }
}
