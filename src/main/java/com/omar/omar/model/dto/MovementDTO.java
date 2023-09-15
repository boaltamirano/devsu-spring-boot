package com.omar.omar.model.dto;

public class MovementDTO {

    private String numeroCuenta;
    private String tipo;
    private Double saldoInical;
    private boolean estado;
    private String movimiento;

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

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

}
