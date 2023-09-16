package com.omar.omar.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.dto.ReportDTO;
import com.omar.omar.model.*;
import com.omar.omar.repository.*;

import jakarta.persistence.EntityNotFoundException;

@Service
@Validated
public class ReportsService {
    private final MoveRepository movementRepository;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public ReportsService(MoveRepository moveRepository, AccountRepository accountRepository, ClientRepository clientRepository) {
        this.movementRepository = moveRepository;
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
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

    public List<ReportDTO> getMovesByClientAndDateRange(String identification, LocalDateTime startDate, LocalDateTime endDate) {
        Client client = clientRepository.getClientByIdentification(identification);
        List<Moves> movesList = movementRepository.findAllByAccount_ClientAndDateBetween(client, startDate, endDate);
        List<ReportDTO> responseDTO = CustomUtils.transformToResponseDTO(movesList);
        return responseDTO;
    }
}
