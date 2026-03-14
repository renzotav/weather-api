package com.renzo.weatherapi.model;


public class Clima {

    private String cidade;
    private int temperatura;
    private int umidade;

    public Clima(String cidade, int temperatura, int umidade){
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

    public int getUmidade(){
        return umidade;
    }
}
