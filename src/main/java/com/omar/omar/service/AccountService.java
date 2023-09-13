package com.omar.omar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account getAccountByNumberAccount(String numberAccount) {
        Account account = accountRepository.getAccountByNumberAccount(numberAccount);
        if (account != null) {
            return account;
        }
        return null;
    }

    public Account updateAccount(String numberAccount, Account account) {

        Account existingAccount = accountRepository.getAccountByNumberAccount(numberAccount);
        if (existingAccount != null) {
            CustomUtils.updateFieldIfNotNull(account.getTypeAccount(), existingAccount::setTypeAccount);
            CustomUtils.updateFieldIfNotNull(account.getStatus(), existingAccount::setStatus);

            existingAccount.setInitialBalance(account.getInitialBalance() != 0.0 ? account.getInitialBalance() : existingAccount.getInitialBalance());
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    @Transactional
    public void deleteAccount(String numberAccount) {
        accountRepository.deleteByNumberAccount(numberAccount);
    }

}
