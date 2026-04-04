package com.finance.dashboard.controller;

import com.finance.dashboard.dto.RecordResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.enums.RecordType;
import com.finance.dashboard.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService service;

    // ✅ Create record (ADMIN only)
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record,
                                  @RequestParam String role) {
        return service.create(record, role);
    }

    // ✅ Get all records (DTO)
    @GetMapping
    public List<RecordResponse> getAll() {
        return service.getAll();
    }

    // ✅ Delete record (ADMIN only)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestParam String role) {
        service.delete(id, role);
    }

    // ✅ Filter records
    @GetMapping("/filter")
    public List<FinancialRecord> filter(@RequestParam RecordType type) {
        return service.getByType(type);
    }
}