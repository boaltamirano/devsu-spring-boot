package com.omar.omar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.Client;
import com.omar.omar.model.dto.AccountDTO;
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
    public AccountDTO createAccount(@Valid Account account) throws ValidationException {

        Client client = clientRepository.getClientByIdentification(account.getClient().getIdentification());
        if (client == null) {
            throw new EntityNotFoundException("No se encontró el cliente con la identificación proporcionada.");
        }
        account.setClient(client);
        return CustomUtils.accountReturn(accountRepository.save(account));
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> getAccounts = accountRepository.findAll();
        return CustomUtils.getAllAccountDTO(getAccounts);
    }

    public Account getAccountByNumberAccount(String numberAccount) {
        Account account = accountRepository.getAccountByNumberAccount(numberAccount);
        if (account != null) {
            return account;
        }
        return null;
    }

}
