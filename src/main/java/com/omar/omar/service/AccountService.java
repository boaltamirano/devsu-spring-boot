package com.omar.omar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.Client;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
@Validated
public class AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public AccountService(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Account createAccount(@Valid Account account) throws ValidationException{

        Client client = clientRepository.getClientByIdentification(account.getClient().getIdentification());
        if (client == null) {
            throw new EntityNotFoundException("No se encontró el cliente con la identificación proporcionada.");
        }
        account.setClient(client);
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
