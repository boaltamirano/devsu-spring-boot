package com.omar.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Moves;

public interface MoveRepository extends JpaRepository<Moves, Long>{
    
    

}
