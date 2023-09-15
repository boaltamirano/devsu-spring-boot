package com.omar.omar.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.omar.omar.model.Moves;
import com.omar.omar.model.dto.ReportDTO;
import com.omar.omar.service.ReportsService;


@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final ReportsService reportsService;

    public ReportsController(ReportsService _reportsService) {
        this.reportsService = _reportsService;
    }

    @GetMapping()
    public List<ReportDTO> getMovesByAccountAndDate(
        @RequestParam String accountId,
        @RequestParam
        String startDate,
        @RequestParam
        String endDate) 
    {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate+"T00:00:00");
        LocalDateTime endDateTime = LocalDateTime.parse(endDate+"T23:59:59");

        return reportsService.getMovesByAccountAndDate(accountId, startDateTime, endDateTime);
    }

}
