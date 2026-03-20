package com.renzo.weatherapi.service;

import com.renzo.weatherapi.dto.ClimaDTO;
import com.renzo.weatherapi.model.Clima;
import com.renzo.weatherapi.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimaService {

    private final ClimaRepository climaRepository;

    public ClimaService(ClimaRepository climaRepository) {
        this.climaRepository = climaRepository;
    }

    public ClimaDTO consultarClima(String cidade) {
        int temperatura = 19;
        int umidade = 75;

        Clima clima = new Clima(cidade, temperatura, umidade);

        clima = climaRepository.save(clima);

        return new ClimaDTO(clima.getCidade(), clima.getTemperatura(), clima.getUmidade());

    }

    public List<ClimaDTO> obterHistorico() {
        return climaRepository.findAll().stream().map(clima -> new ClimaDTO(clima.getCidade(),clima.getTemperatura(),clima.getUmidade())).collect(Collectors.toList());
    }

    public List<ClimaDTO> buscarPorCidade(String cidade) {
        return climaRepository.findByCidade(cidade);
    }

    public List<ClimaDTO> buscarPorTemperatura(int temperatura) {
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