package com.omar.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
