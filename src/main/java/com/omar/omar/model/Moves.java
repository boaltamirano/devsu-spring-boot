package com.omar.omar.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Moves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moveId;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Pattern(regexp = "^(Retiro|Deposito)$", message = "El tipo de movimiento no debe ser 'retiro' o 'deposito'")
    private String typeMove;

    @Min(value = 1, message = "El valor debe ser mayor o igual a 1")
    private double valueMove;

    private double balanceAvailable;

    @JoinColumn(name = "account_id", referencedColumnName = "numberAccount")
    @ManyToOne
    private Account account;

    public Moves() {
    }

    public Long getMoveId() {
        return moveId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTypeMove() {
        return typeMove;
    }

    public void setTypeMove(String typeMove) {
        this.typeMove = typeMove;
    }

    public double getValueMove() {
        return valueMove;
    }

    public void setValueMove(double valueMove) {
        this.valueMove = valueMove;
    }

    public double getBalanceAvailable() {
        return balanceAvailable;
    }

    public void setBalanceAvailable(double balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
