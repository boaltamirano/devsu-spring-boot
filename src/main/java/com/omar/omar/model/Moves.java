package com.omar.omar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.*;

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

    @JoinColumn(name="account_id", referencedColumnName="numberAccount")
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
