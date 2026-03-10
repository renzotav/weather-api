package com.renzo.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClimaController {

    @GetMapping("/clima/{cidade}")
    public String obterClima(@PathVariable String cidade){
        return "Consultando clima da cidade: " + cidade;
    }

}
