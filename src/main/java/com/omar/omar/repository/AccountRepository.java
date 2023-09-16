package com.omar.omar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omar.omar.model.Account;
import com.omar.omar.model.Client;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByNumberAccount(String numberAccount);

    void deleteByNumberAccount(String numberAccount);

    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.movements WHERE a.numberAccount = :numberAccount")
    Optional<Account> getAccountWithMoviments(@Param("numberAccount") String numberAccount);

    List<Account> getByClient(Client client);

}
