package com.renzo.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    @GetMapping("/clima")
    public String obterClima(){
        return "Clima controller funcionando";
    }
    @GetMapping("/status")
    public String retornarStatus(){
        return "API funcionando";
    }
}
