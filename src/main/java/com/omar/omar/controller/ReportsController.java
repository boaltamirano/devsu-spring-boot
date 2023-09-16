package com.omar.omar.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.model.dto.ReportDTO;
import com.omar.omar.service.ReportsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    private static final Logger logger = LoggerFactory.getLogger(ReportsController.class);

    public ReportsController(ReportsService _reportsService) {
        this.reportsService = _reportsService;
    }

    @GetMapping()
    public List<ReportDTO> getMovesByAccountAndDate(
        @RequestParam String accountId,
        @Valid @RequestParam String startDate,
        @Valid @RequestParam String endDate
    ) {
        
        LocalDateTime startDateTime = LocalDateTime.parse(startDate+"T00:00:00");
        LocalDateTime endDateTime = LocalDateTime.parse(endDate+"T23:59:59");
        logger.info("getMovesByAccountAndDate: Se genero reportes de movimientos de una cuenta");
        return reportsService.getMovesByAccountAndDate(accountId, startDateTime, endDateTime);
    }

}
