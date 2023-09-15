package com.omar.omar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.ReportDTO;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.MoveRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Validated
public class ReportsService {
    private final MoveRepository movementRepository;
    private final AccountRepository accountRepository;

    public ReportsService(MoveRepository moveRepository, AccountRepository accountRepository) {
        this.movementRepository = moveRepository;
        this.accountRepository = accountRepository;
    }

    public List<ReportDTO> getMovesByAccountAndDate(String accountId, LocalDateTime startDate, LocalDateTime endDate) {

        Account account = accountRepository.getAccountByNumberAccount(accountId);

        if (account == null) {
            throw new EntityNotFoundException("No se encontró la cuenta con el número proporcionado.");
        }
        List<Moves> movesList = movementRepository.findByAccountAndDateBetween(account, startDate, endDate);
        List<ReportDTO> responseDTO = CustomUtils.transformToResponseDTO(movesList);
        return responseDTO;
    }
}
