package com.omar.omar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.MoveRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Validated
public class MovesService {
    
    private final MoveRepository movementRepository;
    private final AccountRepository accountRepository;

    public MovesService(MoveRepository moveRepository, AccountRepository accountRepository) {
        this.movementRepository = moveRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Moves createMoves(Moves movement) {

        Account account = accountRepository.getAccountByNumberAccount(movement.getAccount().getNumberAccount());
        if (account == null) {
            throw new EntityNotFoundException("No se encontró la cuenta con el número proporcionado.");
        }
        movement.setAccount(account);
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
