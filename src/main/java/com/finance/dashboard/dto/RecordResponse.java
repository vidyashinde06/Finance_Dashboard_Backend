package com.finance.dashboard.dto;

import com.finance.dashboard.entity.enums.RecordType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordResponse {

    private Long id;
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String notes;
}