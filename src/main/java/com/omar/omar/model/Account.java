package com.omar.omar.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Account {
    
    @Id
    private String numberAccount;
    
    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String typeAccount;

    @NotBlank(message = "El saldo inicial es obligatorio")
    private double initialBalance;
    
    private Boolean status;

    @ManyToOne
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

        
}
