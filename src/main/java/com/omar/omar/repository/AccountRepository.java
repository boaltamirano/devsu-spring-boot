package com.omar.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Account createAccount(Account account);
    Account updateAccount(Long accountId, Account account);
    void deleteAccount(Long accountId);
    Account getAccount(Long accountId);

}
