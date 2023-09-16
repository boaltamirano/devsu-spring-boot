package com.omar.omar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.Client;
import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.MovementDTO;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.ClientRepository;
import com.omar.omar.repository.MoveRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
@Validated
public class MovesService {

    private final MoveRepository movementRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public MovesService(MoveRepository moveRepository, AccountRepository accountRepository,
            ClientRepository clientRepository) {
        this.movementRepository = moveRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public MovementDTO createMoves(@Valid Moves movement) throws ValidationException {

        try {
            Account account = accountRepository.getAccountByNumberAccount(movement.getAccount().getNumberAccount());

            if (account == null) {
                throw new EntityNotFoundException("No se encontró la cuenta con el número proporcionado.");
            }

            if (!hasMovementsForAccount(account)) {
                movement.setBalanceAvailable(account.getInitialBalance());
            } else {
                movement.setBalanceAvailable(movementRepository.findTopByAccountOrderByDateDesc(account));
            }

            if ("Retiro".equals(movement.getTypeMove())) {
                validateWithdrawal(movement, account);
            }
            if ("Deposito".equals(movement.getTypeMove())) {
                validateDeposit(movement, account);
            }

            LocalDateTime dateNow = LocalDateTime.now();
            movement.setAccount(account);
            movement.setDate(dateNow);
            return CustomUtils.movementReturn(movementRepository.save(movement));
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public Moves getMovementById(Long movementId) {
        Moves movement = movementRepository.getReferenceById(movementId);
        if (movement != null) {
            return movement;
        }
        return null;
    }

    public List<Moves> getMovesByClientAndDateRange(String identification, LocalDateTime startDate, LocalDateTime endDate) {
        Client client = clientRepository.getClientByIdentification(identification);
        return movementRepository.findAllByAccount_ClientAndDateBetween(client, startDate, endDate);
    }

    /************** Helper functions **************/
    private void validateWithdrawal(Moves movement, Account account) throws ValidationException {
        double totalValueToday = getTotalValueMoveForTodayByAccount(account);

        if (totalValueToday + movement.getValueMove() > 1000) {
            throw new EntityNotFoundException("Cupo diario Excedido");
        }
        if (movement.getValueMove() > movement.getBalanceAvailable()) {
            throw new EntityNotFoundException("Saldo no disponible");
        }

        double newBalance = movement.getBalanceAvailable() - movement.getValueMove();
        movement.setBalanceAvailable(newBalance);
    }

    public Long getTotalValueMoveForTodayByAccount(Account account) {
        LocalDateTime currentDate = LocalDateTime.now();
        Long totalToday = movementRepository.getCountOfMovesForTodayByAccount(account, currentDate);
        return totalToday == null ? 0 : totalToday;
    }

    private void validateDeposit(Moves movement, Account account) {
        double newBalance = movement.getBalanceAvailable() + movement.getValueMove();
        movement.setBalanceAvailable(newBalance);
    }

    private boolean hasMovementsForAccount(Account account) {
        try {
            Integer newAccount = movementRepository.getByAccountNumberAccount(account);
            return newAccount > 0;
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
