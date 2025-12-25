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
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceId) {
        EligibilityCheckRecord rec = new EligibilityCheckRecord();
        rec.setEmployeeId(employeeId);
        rec.setDeviceId(deviceId);
        rec.setIsEligible(true);   // ✅ correct name
        return repository.save(rec);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }

    // NOT in interface → NO @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}
