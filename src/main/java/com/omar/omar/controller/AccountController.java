package com.omar.omar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.dto.AccountDTO;
import com.omar.omar.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account, BindingResult result) {
        AccountDTO accountDTO = accountService.createAccount(account);

        if (accountDTO == null) {
            logger.info("Ya existe una cuenta con el numero " + account.getNumberAccount());
            Map<String, String> response = new HashMap<>();
            response.put("message", "Ya existe una cuenta con el numero " + account.getNumberAccount());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        logger.info("Se creo una cuenta correctamente");
        return CustomUtils.createEntityResponse(account, () -> accountDTO, result);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        logger.info("Se ha consultado la lista de todas las cuentas.");
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{numberAccount}")
    public ResponseEntity<AccountDTO> getAccountByIdentification(@PathVariable String numberAccount) {
        AccountDTO account = accountService.getAccountByNumberAccount(numberAccount);
        if (account != null) {
            logger.info("Se ha consultado la cuenta con número de cuenta: {}", numberAccount);
            return ResponseEntity.ok(account);
        }
        logger.info("No se ha encontrado la cuenta con número de cuenta: {}", numberAccount);
        return ResponseEntity.notFound().build();
    }

}
