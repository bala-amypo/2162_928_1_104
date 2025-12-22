package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRecordRepository repository;

    public EligibilityCheckServiceImpl(EligibilityCheckRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);
        record.setIsEligible(true);
        record.setReason("Eligible");

        return repository.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }
}
