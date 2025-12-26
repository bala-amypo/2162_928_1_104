package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository repository;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {

        if (record.getEmployeeId() == null || record.getDeviceItemId() == null) {
            throw new BadRequestException("EmployeeId and DeviceItemId are required");
        }

        record.setStatus("ISSUED");
        record.setIssuedAt(LocalDateTime.now());
        record.setReturnedDate(null);

        return repository.save(record);
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long recordId) {

        IssuedDeviceRecord record = repository.findById(recordId)
                .orElseThrow(() -> new BadRequestException("Issued record not found"));

        if ("RETURNED".equalsIgnoreCase(record.getStatus())) {
            throw new BadRequestException("Device already returned");
        }

        record.setStatus("RETURNED");
        record.setReturnedDate(LocalDateTime.now());

        return repository.save(record);
    }

    @Override
    public List<IssuedDeviceRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}
