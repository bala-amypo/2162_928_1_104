package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EligibilityCheckRecord;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();

        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);
        record.setIsEligible(true);
        record.setReason("Eligible");


        return record;
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return new ArrayList<>();
    }
}
