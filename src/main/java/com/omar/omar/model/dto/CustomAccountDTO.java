package com.omar.omar.model.dto;

public class CustomAccountDTO {
    private String Fecha;
    private String Cliente;
    private String NumeroCuenta;
    private String Tipo;
    private Double SaldoInicial;
    private Boolean Estado;
    private Double Movimiento;
    private Double SaldoDisponible;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        SaldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }

    public Double getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(Double movimiento) {
        Movimiento = movimiento;
    }

    public Double getSaldoDisponible() {
        return SaldoDisponible;
    }

    public void setSaldoDisponible(Double saldoDisponible) {
        SaldoDisponible = saldoDisponible;
    }

}
