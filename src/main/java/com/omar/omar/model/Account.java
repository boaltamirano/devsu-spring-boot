package com.omar.omar.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
public class Account {

    @Id
    private String numberAccount;

    @NotBlank(message = "El tipo de cuenta es obligatorio")
    @Pattern(regexp = "^(Ahorro|Corriente)$", message = "El tipo de cuenta debe ser 'Ahorro' o 'Corriente'")
    private String typeAccount;

    @NotNull(message = "El saldo inicial es obligatorio")
    @Min(value = 0, message = "El saldo inicial no puede ser menor que 0")
    private Double initialBalance;

    private Boolean status;

	@JoinColumn(name="client_id", referencedColumnName="identification")
	@ManyToOne
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Moves> movements;

    public Account() {
    }

    public Account(String numberAccount) {
        super();
        this.numberAccount = numberAccount;
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
