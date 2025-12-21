package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.EligibilityCheckRecord;

public interface EligibilityCheckRecordRepository {

    List<EligibilityCheckRecord> findByEmployeeId(Long employeeId);
}
