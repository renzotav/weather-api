package com.renzo.weatherapi.service;

import com.renzo.weatherapi.model.Clima;
import org.springframework.stereotype.Service;

@Service
public class ClimaService {

    public Clima consultarClima(String cidade){
        int temperatura = 25;
        int umidade = 70;
        return new Clima(cidade, temperatura, umidade);
    }

}
