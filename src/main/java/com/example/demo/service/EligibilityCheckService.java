package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;
import java.util.List;

public interface EligibilityCheckService {
    EligibilityCheckRecord save(EligibilityCheckRecord record);
    List<EligibilityCheckRecord> getAll();
}
