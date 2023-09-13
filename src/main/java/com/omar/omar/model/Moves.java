package com.omar.omar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private double value;
    private double balance;

    public Moves() {
    }

    public Long getMoveId() {
        return moveId;
    }

    public Date getDate() {
        return date;
    }

    // public void setDate(Date date) {
    //     this.date = date;
    // }

    public String getTypeMove() {
        return typeMove;
    }

    public void setTypeMove(String typeMove) {
        this.typeMove = typeMove;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
