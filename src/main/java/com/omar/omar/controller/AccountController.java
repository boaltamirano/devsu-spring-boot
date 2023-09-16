package com.omar.omar.controller;

import java.util.List;

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

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account, BindingResult result) {
        return CustomUtils.createEntityResponse(account, () -> accountService.createAccount(account), result);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{numberAccount}")
    public ResponseEntity<AccountDTO> getAccountByIdentification(@PathVariable String numberAccount) {
        AccountDTO account = accountService.getAccountByNumberAccount(numberAccount);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

}
