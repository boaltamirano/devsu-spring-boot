package com.omar.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Person;

public interface ClientRepository extends JpaRepository<Person, Long> {
    
}
