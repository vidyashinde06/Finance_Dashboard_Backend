package com.finance.dashboard.entity;

import com.finance.dashboard.entity.enums.RecordType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class FinancialRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private RecordType type;

    private String category;
    private LocalDate date;
    private String notes;

    @ManyToOne
    private User user;
}