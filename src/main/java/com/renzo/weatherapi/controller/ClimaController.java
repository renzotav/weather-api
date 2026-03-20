package com.renzo.weatherapi.controller;

import com.renzo.weatherapi.dto.ClimaDTO;
import com.renzo.weatherapi.model.Clima;

import com.renzo.weatherapi.response.ApiResponse;
import com.renzo.weatherapi.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClimaController {

    private final ClimaService climaService;


    public ClimaController(ClimaService climaService){
        this.climaService = climaService;
    }

    @GetMapping("/clima/{cidade}")
    public ApiResponse<ClimaDTO> obterClima(@PathVariable String cidade){
        ClimaDTO clima = climaService.consultarClima(cidade);

        return new ApiResponse<>(true, clima, null);
    }

    @GetMapping("/historico")
    public ApiResponse<List<ClimaDTO>> obterHistorico(){
        List<ClimaDTO> lista = climaService.obterHistorico();
        return new ApiResponse<>(true, lista, null);
    }

    @GetMapping("/clima/cidade/{cidade}")
    public ApiResponse <List<ClimaDTO>> buscarPorCidade(@PathVariable String cidade){
        List<ClimaDTO> lista = climaService.buscarPorCidade(cidade);
        return new ApiResponse<>(true, lista, null);
    }

    @GetMapping("/clima/temperatura/{temperatura}")
    public List<ClimaDTO> buscarPorTemperatura(@PathVariable int temperatura){
        return climaService.buscarPorTemperatura(temperatura);
    }
    @GetMapping("/clima/filtro/{cidade}/{temperatura}")
    public List<Clima> buscarPorCidadeETemperatura(@PathVariable String cidade, @PathVariable int temperatura ){
        return climaService.buscarPorCidadeETemperatura(cidade, temperatura);
    }
    @GetMapping("/clima/busca/{cidade}")
    public List<Clima> buscarPorNomeParcial(@PathVariable String cidade){
        return climaService.buscarPorNomeParcial(cidade);
    }
    @GetMapping("/clima/ordenado")
    public List<Clima> listarOrdenadoPorTemperatura(){
        return climaService.listarOrdenadoPorTemperatura();
    }
}
