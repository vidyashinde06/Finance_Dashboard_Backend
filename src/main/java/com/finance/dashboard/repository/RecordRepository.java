package com.finance.dashboard.repository;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {
    List<FinancialRecord> findByType(RecordType type);
    @Query("SELECT SUM(r.amount) FROM FinancialRecord r WHERE r.type = :type")
    Double sumByType(RecordType type);

    @Query("SELECT r.category, SUM(r.amount) FROM FinancialRecord r GROUP BY r.category")
    List<Object[]> groupByCategory();
}