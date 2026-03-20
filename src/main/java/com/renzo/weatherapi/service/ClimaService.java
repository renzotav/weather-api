package com.renzo.weatherapi.service;

import com.renzo.weatherapi.dto.ClimaDTO;
import com.renzo.weatherapi.external.ClimaResponse;
import com.renzo.weatherapi.model.Clima;
import com.renzo.weatherapi.repository.ClimaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClimaService {

    private final ClimaRepository climaRepository;
    private final RestTemplate restTemplate;

    public ClimaService(ClimaRepository climaRepository, RestTemplate restTemplate) {
        this.climaRepository = climaRepository;
        this.restTemplate = restTemplate;
    }

    public ClimaDTO consultarClima(String cidade) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + cidade
                + "&appid=63e10209c72dd66d0c89fa2c5cdef550&units=metric";

        ClimaResponse response = restTemplate.getForObject(url, ClimaResponse.class);

        int temperatura = (int) response.getMain().getTemp();
        int umidade = response.getMain().getHumidity();

        Clima clima = new Clima(cidade, temperatura, umidade);

        clima = climaRepository.save(clima);

        return new ClimaDTO(clima.getCidade(), clima.getTemperatura(), clima.getUmidade());

    }

    public List<ClimaDTO> obterHistorico() {
        return climaRepository.findAll().stream().map(clima -> new ClimaDTO(
                clima.getCidade(),
                clima.getTemperatura(),
                clima.getUmidade())).collect(Collectors.toList());
    }

    public List<ClimaDTO> buscarPorCidade(String cidade) {
        return climaRepository.findByCidade(cidade).stream().map(clima -> new ClimaDTO(
                clima.getCidade(),
                clima.getTemperatura(),
                clima.getUmidade()
        )).collect(Collectors.toList());

    }

    public List<ClimaDTO> buscarPorTemperatura(int temperatura) {
        return climaRepository.findByTemperatura(temperatura).stream().map(clima -> new ClimaDTO(
                clima.getCidade(),
                clima.getTemperatura(),
                clima.getUmidade()
        )).collect(Collectors.toList());
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