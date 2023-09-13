package com.omar.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.omar.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByNumberAccount(String numberAccount);

    void deleteByNumberAccount(String numberAccount);

}
