package com.omar.omar.model.dto;

public class AccountDTO {

    private String numeroCuenta;
    private String tipo;
    private Double saldoInical;
    private boolean estado;
    private String cliente;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldoInical() {
        return saldoInical;
    }

    public void setSaldoInical(Double saldoInical) {
        this.saldoInical = saldoInical;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
