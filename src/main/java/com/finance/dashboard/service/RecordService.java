package com.finance.dashboard.service;

import com.finance.dashboard.dto.RecordResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.enums.RecordType;
import com.finance.dashboard.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    // ✅ Role check
    private void checkAdmin(String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            throw new RuntimeException("Access Denied: Admin only");
        }
    }

    // ✅ Create record
    public FinancialRecord create(FinancialRecord record, String role) {
        checkAdmin(role);
        return recordRepository.save(record);
    }

    // ✅ Get all records (DTO)
    public List<RecordResponse> getAll() {
        return recordRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Delete record
    public void delete(Long id, String role) {
        checkAdmin(role);
        recordRepository.deleteById(id);
    }

    // ✅ Filter by type
    public List<FinancialRecord> getByType(RecordType type) {
        return recordRepository.findByType(type);
    }

    // ✅ Convert Entity → DTO
    private RecordResponse mapToDTO(FinancialRecord record) {
        RecordResponse dto = new RecordResponse();
        dto.setId(record.getId());
        dto.setAmount(record.getAmount());
        dto.setType(record.getType());
        dto.setCategory(record.getCategory());
        dto.setDate(record.getDate());
        dto.setNotes(record.getNotes());
        return dto;
    }
}