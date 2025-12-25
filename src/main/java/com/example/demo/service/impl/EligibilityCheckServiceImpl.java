package com.example.demo.service.impl;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRecordRepository eligibilityRepo;

    public EligibilityCheckServiceImpl(
            EmployeeProfileRepository employeeRepo,
            DeviceCatalogItemRepository deviceRepo,
            IssuedDeviceRecordRepository issuedRepo,
            PolicyRuleRepository policyRepo,
            EligibilityCheckRecordRepository eligibilityRepo
    ) {
        this.eligibilityRepo = eligibilityRepo;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);
        record.setIsEligible(true);
        record.setReason("Eligible");
        record.setCheckedAt(LocalDateTime.now());
        return eligibilityRepo.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return eligibilityRepo.findAll();
    }
}
