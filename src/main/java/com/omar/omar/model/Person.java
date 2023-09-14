package com.omar.omar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@MappedSuperclass
public class Person {

    @Id
    @NotBlank(message = "La identificación es obligatoria")
    private String identification;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El género es obligatorio")
    private String genre;

    @Min(value = 16, message = "La edad debe ser mayor o igual a 16")
    @Max(value = 90, message = "La edad debe ser menor o igual a 90")
    private int age;

    private String address;

    private String phone;

    public Person() {
        super();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
