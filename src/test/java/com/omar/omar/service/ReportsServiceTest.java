package com.omar.omar.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.ReportDTO;
import com.omar.omar.repository.AccountRepository;
import com.omar.omar.repository.MoveRepository;

public class ReportsServiceTest {
    @InjectMocks
    private ReportsService reportsService;

    @Mock
    private MoveRepository moveRepository;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovesByAccountAndDate() {
        String accountId = "123";
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59);
        Account account = new Account();
        account.setNumberAccount(accountId);

        List<Moves> movesList = new ArrayList<>();
        when(accountRepository.getAccountByNumberAccount(accountId)).thenReturn(account);
        when(moveRepository.findByAccountAndDateBetween(account, startDate, endDate)).thenReturn(movesList);
        List<ReportDTO> result = reportsService.getMovesByAccountAndDate(accountId, startDate, endDate);

        assertNotNull(result);
    }
}
