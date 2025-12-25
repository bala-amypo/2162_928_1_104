package com.example.demo.service;

import com.example.demo.model.IssuedDeviceRecord;
import java.util.List;

public interface IssuedDeviceRecordService {
    IssuedDeviceRecord save(IssuedDeviceRecord record);
    List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId);
}
