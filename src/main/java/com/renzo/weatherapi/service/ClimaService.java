package com.renzo.weatherapi.service;

import com.renzo.weatherapi.model.Clima;
import com.renzo.weatherapi.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClimaService {

    private final ClimaRepository climaRepository;

    public ClimaService(ClimaRepository climaRepository) {
        this.climaRepository = climaRepository;
    }

    public Clima consultarClima(String cidade) {
        int temperatura = 19;
        int umidade = 75;

        Clima clima = new Clima(cidade, temperatura, umidade);

        return climaRepository.save(clima);
    }

    public List<Clima> obterHistorico() {
        return climaRepository.findAll();
    }

    public List<Clima> buscarPorCidade(String cidade) {
        return climaRepository.findByCidade(cidade);
    }

    public List<Clima> buscarPorTemperatura(int temperatura) {
        return climaRepository.findByTemperatura(temperatura);
    }

    public List<Clima> buscarPorCidadeETemperatura(String cidade, int temperatura) {
        return climaRepository.findByCidadeAndTemperatura(cidade, temperatura);
    }

    public List<Clima> buscarPorNomeParcial(String cidade) {
        return climaRepository.findByCidadeContaining(cidade);
    }

    public List<Clima> listarOrdenadoPorTemperatura(){
        return climaRepository.findAllByOrderByTemperaturaAsc();
    }

}