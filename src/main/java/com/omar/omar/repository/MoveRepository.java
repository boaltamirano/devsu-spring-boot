package com.omar.omar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;

public interface MoveRepository extends JpaRepository<Moves, Long>{

    List<Moves> getMovementByAccount(Account account);
    
}
