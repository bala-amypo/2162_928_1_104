package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;

import java.util.List;

public interface EligibilityCheckService {

    EligibilityCheckRecord saveRecord(EligibilityCheckRecord record);

    List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId);

    // 🔧 REQUIRED BY CONTROLLER
    EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceId);

    List<EligibilityCheckRecord> getAll();
}
