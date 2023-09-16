package com.omar.omar.model.dto;

public class ReportDTO {

    private String Fecha;
    private String Cliente;
    private String NumeroCuenta;
    private String Tipo;
    private double SaldoInicial;
    private boolean Estado;
    private double Movimiento;
    private double SaldoDisponible;

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

    public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        SaldoInicial = saldoInicial;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    public double getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(double movimiento) {
        Movimiento = movimiento;
    }

    public double getSaldoDisponible() {
        return SaldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        SaldoDisponible = saldoDisponible;
    }

}
