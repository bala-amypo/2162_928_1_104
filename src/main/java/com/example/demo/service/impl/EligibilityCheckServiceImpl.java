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

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord rec = new EligibilityCheckRecord();
        rec.setEmployeeId(employeeId);
        rec.setDeviceItemId(deviceItemId);
        rec.setIsEligible(true);
        rec.setReason("ELIGIBLE");
        return repository.save(rec);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}
