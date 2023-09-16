package com.omar.omar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("Se creo una cuenta correctamente");
        return CustomUtils.createEntityResponse(account, () -> accountService.createAccount(account), result);
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
