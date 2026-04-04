package com.finance.dashboard.controller;

import com.finance.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping("/summary")
    public Map<String, Double> summary() {
        return service.getSummary();
    }

    @GetMapping("/categories")
    public List<Object[]> categorySummary() {
        return service.categorySummary();
    }
}