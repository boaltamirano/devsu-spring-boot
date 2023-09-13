package com.omar.omar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Moves {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moveId;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String typeMove;
    private double valueMove;
    private double balanceAvailable;

    @ManyToOne
    private Account account;

    public Moves() {
    }

    public Long getMoveId() {
        return moveId;
    }

    public Date getDate() {
        return date;
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

    @PrePersist
    protected void onCreate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.date = sdf.parse("10/2/2022");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
