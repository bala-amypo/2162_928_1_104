package com.example.demo.service;

import com.example.demo.entity.EligibilityCheckRecord;
import java.util.List;

public interface EligibilityCheckService {
    EligibilityCheckRecord save(EligibilityCheckRecord record);
    List<EligibilityCheckRecord> getAll();
}
