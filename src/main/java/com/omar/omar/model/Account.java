package com.omar.omar.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    private String numberAccount;

    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String typeAccount;

    @NotNull(message = "El saldo inicial es obligatorio")
    private Double initialBalance;

    private Boolean status;

    @ManyToOne
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Moves> movements;

    public Account() {
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Moves> getMovements() {
        return movements;
    }

    public void setMovements(List<Moves> movements) {
        this.movements = movements;
    }

    @Transient
    public Client getClientInfo() {
        return this.client;
    }

}
