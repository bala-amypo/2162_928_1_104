package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.IssuedDeviceRecord;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        record.setStatus("ISSUED");
        return record;
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long recordId) {
        IssuedDeviceRecord record = new IssuedDeviceRecord();
        record.setId(recordId);
        record.setStatus("RETURNED");
        return record;
    }

    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return new ArrayList<>();
    }
}
