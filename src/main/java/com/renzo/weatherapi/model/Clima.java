package com.renzo.weatherapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cidade;
    private int temperatura;
    private int umidade;

    public Clima(){}

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
