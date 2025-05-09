package com.prueba.genesis.dtos;

public class PrestamoRequestDTO {
    private Integer monto;
    private Integer numeroCuotas;
    private String dpiCliente;

     
    public Integer getMonto() {
        return monto;
    }

    public Integer getNumeroCuotas() {
        return numeroCuotas;
    }

    public String getDpiCliente() {
        return dpiCliente;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void setNumeroCuotas(Integer numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public void setDpiCliente(String dpiCliente) {
        this.dpiCliente = dpiCliente;
    }
}