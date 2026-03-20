package com.renzo.weatherapi.dto;


public class ClimaDTO {

    private String cidade;
    private int temperatura;
    private int umidade;

    public ClimaDTO(String cidade, int temperatura, int umidade){
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public String getCidade() {
        return cidade;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getUmidade() {
        return umidade;
    }
}
