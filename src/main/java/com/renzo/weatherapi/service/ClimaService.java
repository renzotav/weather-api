package com.renzo.weatherapi.service;

import com.renzo.weatherapi.model.Clima;
import com.renzo.weatherapi.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClimaService {

    private final ClimaRepository climaRepository;

    public ClimaService(ClimaRepository climaRepository){
        this.climaRepository = climaRepository;
    }
    public Clima consultarClima(String cidade){
        int temperatura = 25;
        int umidade = 70;

        Clima clima = new Clima(cidade, temperatura, umidade);

        return climaRepository.save(clima);
    }
    public List<Clima> obterHistorico(){
        return climaRepository.findAll();
    }

}
