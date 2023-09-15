package com.omar.omar.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;

public interface MoveRepository extends JpaRepository<Moves, Long> {

    List<Moves> getMovementByAccount(Account account);

    @Query("SELECT SUM(m.valueMove) FROM Moves m WHERE m.account = :account AND DATE(m.date) = DATE(:currentDate) AND m.typeMove = 'Retiro'")
    Long getCountOfMovesForTodayByAccount(@Param("account") Account account, @Param("currentDate") LocalDateTime currentDate);
}
