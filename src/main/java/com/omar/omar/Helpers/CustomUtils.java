package com.omar.omar.Helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.omar.omar.model.Account;
import com.omar.omar.model.Client;
import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.ValidationException;

public class CustomUtils {

    private static final Logger logger = LoggerFactory.getLogger(CustomUtils.class);

    public static <T> void updateFieldIfNotNull(T newValue, Consumer<T> updater) {
        if (newValue != null) {
            updater.accept(newValue);
        }
    }

    public static ResponseEntity<Object> buildErrorResponse(HttpStatus status, String errorMessage) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);
        return ResponseEntity.status(status).body(errorResponse);
    }

    public static <T> ResponseEntity<?> createEntityResponse(T entity, Supplier<T> creationFunction, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> errorResponse = new HashMap<>();
            String errorMessage = result.getFieldError().getDefaultMessage();
            errorResponse.put("error", errorMessage);
            logger.error(errorMessage);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {
            T createdEntity = creationFunction.get();
            logger.error("Se creo un registro de " + entity.toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
        } catch (ValidationException e) {
            logger.error(e.getMessage());
            return buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public static List<ReportDTO> transformToResponseDTO(List<Moves> movesList) {

        List<ReportDTO> reportsList = new ArrayList<>();

        for (Moves movement : movesList) {
            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setFecha(ConvertDate(movement.getDate()));
            reportDTO.setCliente(movement.getAccount().getClient().getName());
            reportDTO.setNumeroCuenta(movement.getAccount().getNumberAccount());
            reportDTO.setTipo(movement.getAccount().getTypeAccount());
            reportDTO.setSaldoInicial(movement.getAccount().getInitialBalance());
            reportDTO.setEstado(movement.getAccount().getStatus());
            reportDTO.setMovimiento(movement.getValueMove());
            reportDTO.setSaldoDisponible(movement.getBalanceAvailable());
            reportsList.add(reportDTO);
        }

        return reportsList;
    }

    private static String ConvertDate(LocalDateTime originalDate) {
        DateTimeFormatter myNewFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return originalDate.format(myNewFormat);
    }

    public static ClientDTO clientReturn(Client client) {

        ClientDTO clientResponse = new ClientDTO();
        clientResponse.setNombres(client.getName());
        clientResponse.setDirección(client.getAddress());
        clientResponse.setTeléfono(client.getPhone());
        clientResponse.setContraseña(client.getPassword());
        clientResponse.setEstado(client.getStatus());

        return clientResponse;
    }

    public static List<AccountDTO> getAllAccountDTO(List<Account> accounts) {

        List<AccountDTO> accountList = new ArrayList<>();

        for (Account account : accounts) {
            accountList.add(accountReturn(account));
        }
        return accountList;
    }

    public static AccountDTO accountReturn(Account account) {

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setNumeroCuenta(account.getNumberAccount());
        accountDTO.setTipo(account.getTypeAccount());
        accountDTO.setSaldoInical(account.getInitialBalance());
        accountDTO.setEstado(account.getStatus());
        accountDTO.setCliente(account.getClient().getName());

        return accountDTO;
    }

    public static MovementDTO movementReturn(Moves movement) {

        MovementDTO movementDTO = new MovementDTO();
        movementDTO.setNumeroCuenta(movement.getAccount().getNumberAccount());
        movementDTO.setTipo(movement.getAccount().getTypeAccount());
        movementDTO.setSaldoInical(movement.getAccount().getInitialBalance());
        movementDTO.setEstado(movement.getAccount().getStatus());
        movementDTO.setMovimiento(movement.getTypeMove() + " de " + movement.getValueMove());

        return movementDTO;
    }

}
