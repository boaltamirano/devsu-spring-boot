package com.omar.omar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
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
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{numberAccount}")
    public ResponseEntity<Account> getAccountByIdentification(@PathVariable String numberAccount) {
        Account account = accountService.getAccountByNumberAccount(numberAccount);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{numberAccount}")
    public ResponseEntity<Account> updateAccount(@PathVariable String numberAccount, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(numberAccount, account);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{numberAccount}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String numberAccount) {
        accountService.deleteAccount(numberAccount);
        return ResponseEntity.noContent().build();
    }

}
