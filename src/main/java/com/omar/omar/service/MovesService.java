package com.omar.omar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omar.omar.model.Moves;
// import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.MoveRepository;

@Service
public class MovesService {
    
    @Autowired
    private MoveRepository movementRepository;

    // @Autowired
    // private AccountRepository accountRepository;

    public Moves createMoves(Moves movement) {

        return movementRepository.save(movement);
    }


    public List<Moves> getAllMovements() {
        return (List<Moves>) movementRepository.findAll();
    }


    public Moves getMovementById(Long movementId) {
        Moves movement = movementRepository.getReferenceById(movementId);
        if (movement != null) {
            return movement;
        }
        return null;
    }


    @Transactional
    public void deleteMoves(Long movementId) {
        movementRepository.deleteById(movementId);
    }

}
