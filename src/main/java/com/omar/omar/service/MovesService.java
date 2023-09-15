package com.omar.omar.service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.CustomAccountDTO;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.MoveRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

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
    public Moves createMoves(@Valid Moves movement) throws ValidationException {

        Account account = accountRepository.getAccountByNumberAccount(movement.getAccount().getNumberAccount());
    
        if (account == null) {
            throw new EntityNotFoundException("No se encontró la cuenta con el número proporcionado.");
        }
    
        if ("Retiro".equals(movement.getTypeMove())) {
            validateWithdrawal(movement, account);
        }  
        if ("Deposito".equals(movement.getTypeMove())) {
            validateDeposit(movement, account);
        }
    
        Date dateNow = new Date();
        movement.setAccount(account);
        movement.setDate(dateNow);
        return movementRepository.save(movement);
    }

    public List<Moves> getAllMovements() {
        return (List<Moves>) movementRepository.findAll();
    }

    public List<Moves> getMovementByAccount(Account account) {
        return (List<Moves>) movementRepository.getMovementByAccount(account);
    }

    public List<CustomAccountDTO> getAllMovementss(List<Moves> moves) {
        // return (List<Moves>) movementRepository.findAll();
        List<CustomAccountDTO> moveDTOList = new ArrayList<>();
        for (Moves move : moves) {
            CustomAccountDTO moveDTO = new CustomAccountDTO();
            moveDTO.setCliente(move.getAccount().getClient().getName());
            moveDTO.setNumeroCuenta(move.getAccount().getNumberAccount());
            moveDTO.setTipo(move.getAccount().getTypeAccount());
            moveDTO.setSaldoInicial(move.getAccount().getInitialBalance());
            moveDTO.setEstado(move.getAccount().getStatus());
            moveDTO.setMovimiento(move.getValueMove());
            moveDTO.setSaldoDisponible(move.getBalanceAvailable());

            moveDTOList.add(moveDTO);
        }
        return moveDTOList;
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

    /************** Helper functions **************/
    private void validateWithdrawal(Moves movement, Account account) throws ValidationException {
        double totalValueToday = getTotalValueMoveForTodayByAccount(account);

        if (totalValueToday + movement.getValueMove() > 1000) {
            throw new EntityNotFoundException("Cupo diario Excedido");
        }
        if (movement.getValueMove() > account.getInitialBalance()) {
            throw new EntityNotFoundException("Saldo no disponible");
        }

        double newBalance = account.getInitialBalance() - movement.getValueMove();
        movement.setBalanceAvailable(newBalance);
    }

    private void validateDeposit(Moves movement, Account account) {
        double newBalance = account.getInitialBalance() + movement.getValueMove();
        movement.setBalanceAvailable(newBalance);
    }

    public Long getTotalValueMoveForTodayByAccount(Account account) {
        LocalDateTime currentDate = LocalDateTime.now();
        return movementRepository.getCountOfMovesForTodayByAccount(account, currentDate);
    }

}
