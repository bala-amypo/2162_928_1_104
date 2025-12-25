package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;
import java.util.List;

public interface EligibilityCheckService {

    EligibilityCheckRecord validateEligibility(long employeeId, long deviceItemId);

    List<EligibilityCheckRecord> getAll();

    List<EligibilityCheckRecord> getChecksByEmployee(long employeeId);
}
