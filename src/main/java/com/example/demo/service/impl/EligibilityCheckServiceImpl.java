package com.example.demo.service.impl;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EligibilityCheckRecordRepository repository;

    public EligibilityCheckServiceImpl(EligibilityCheckRecordRepository repository) {
        this.repository = repository;
    }

    // helper method (not in interface)
    public EligibilityCheckRecord save(EligibilityCheckRecord record) {
        return repository.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public EligibilityCheckRecord validateEligibility(long employeeId, long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceId(deviceItemId);
        record.setIsEligible(true);
        return repository.save(record);
    }
}
