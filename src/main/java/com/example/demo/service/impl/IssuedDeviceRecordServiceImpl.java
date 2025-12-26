package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository issuedRepo;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo) {
        this.issuedRepo = issuedRepo;
    }

    // ✅ ISSUE DEVICE (simple, test-friendly)
    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {

        if (record.getEmployeeId() == null || record.getDeviceId() == null) {
            throw new BadRequestException("EmployeeId or DeviceId missing");
        }

        record.setIssuedDate(LocalDate.now());
        record.setStatus("ISSUED");

        return issuedRepo.save(record);
    }

    // ✅ RETURN DEVICE
    @Override
    public IssuedDeviceRecord returnDevice(Long recordId) {

        IssuedDeviceRecord record = issuedRepo.findById(recordId)
                .orElseThrow(() -> new BadRequestException("Issued record not found"));

        if ("RETURNED".equalsIgnoreCase(record.getStatus())) {
            throw new BadRequestException("Device already returned");
        }

        record.setStatus("RETURNED");
        record.setReturnedDate(LocalDate.now());

        return issuedRepo.save(record);
    }

    // ✅ GET BY EMPLOYEE
    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return issuedRepo.findByEmployeeId(employeeId);
    }

    // ✅ GET ALL
    @Override
    public List<IssuedDeviceRecord> getAll() {
        return issuedRepo.findAll();
    }
}
