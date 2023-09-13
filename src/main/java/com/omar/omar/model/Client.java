package com.omar.omar.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends Person{
    
    private String password;
    private String status;

    public Client() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
