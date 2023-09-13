package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.omar.model.Account;
import com.omar.omar.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createAccount);
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
