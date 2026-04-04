package com.finance.dashboard.service;

import com.finance.dashboard.entity.enums.RecordType;
import com.finance.dashboard.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final RecordRepository recordRepository;

    public Map<String, Double> getSummary() {

        Double income = recordRepository.sumByType(RecordType.INCOME);
        Double expense = recordRepository.sumByType(RecordType.EXPENSE);

        Map<String, Double> result = new HashMap<>();

        result.put("income", income == null ? 0 : income);
        result.put("expense", expense == null ? 0 : expense);
        result.put("net", (income == null ? 0 : income) - (expense == null ? 0 : expense));

        return result;
    }

    public List<Object[]> categorySummary() {
        return recordRepository.groupByCategory();
    }
}