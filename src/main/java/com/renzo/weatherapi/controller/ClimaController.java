package com.renzo.weatherapi.controller;

import com.renzo.weatherapi.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService){
        this.climaService = climaService;
    }

    @GetMapping("/clima/{cidade}")
    public String obterClima(@PathVariable String cidade){
        return climaService.consultarClima(cidade);
    }

    @GetMapping("/temperatura/{cidade}")
        public String obterTemperatura(@PathVariable String cidade){
        return climaService.consultarTemperatura(cidade);
    }



}
