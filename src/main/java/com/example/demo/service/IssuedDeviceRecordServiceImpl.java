package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repository;

    // ✅ CONSTRUCTOR INJECTION (Correct)
    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {
        record.setStatus("ISSUED");
        return repository.save(record); // ✅ SAVES TO DB
    }

    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId); // ✅ FETCHES FROM DB
    }
}
