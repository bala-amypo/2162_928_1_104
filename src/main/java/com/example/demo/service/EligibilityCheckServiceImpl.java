package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;

@Service
public class EligibilityCheckServiceImpl {

    private final EligibilityCheckRecordRepository repository;

    public EligibilityCheckServiceImpl(EligibilityCheckRecordRepository repository) {
        this.repository = repository;
    }

    public EligibilityCheckRecord validateEligibility(Long empId, Long deviceId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(empId);
        record.setDeviceItemId(deviceId);
        record.setIsEligible(true);
        record.setReason("Eligible");

        return repository.save(record); // 🔥 IMPORTANT
    }

    public List<EligibilityCheckRecord> getAll() {
        return repository.findAll();
    }
}
