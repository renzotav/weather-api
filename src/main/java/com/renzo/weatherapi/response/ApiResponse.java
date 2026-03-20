package com.renzo.weatherapi.response;

public class ApiResponse<T> {

    private boolean sucesso;
    private T dados;
    private String erro;

    public ApiResponse(boolean sucesso, T dados, String erro){
        this.sucesso = sucesso;
        this.dados = dados;
        this.erro = erro;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public T getDados() {
        return dados;
    }

    public String getErro() {
        return erro;
    }
}
