package com.renzo.weatherapi.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimaResponse {

    private Main main;

    public Main getMain(){
        return main;
    }
    public void setMain(Main main){
        this.main = main;
    }
public static class Main{
        private double temp;
        private int humidity;

    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp){
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }
    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
}

}
