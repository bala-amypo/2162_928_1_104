package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {

    private final IssuedDeviceRecordRepository issuedRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;

    public IssuedDeviceRecordServiceImpl(
            IssuedDeviceRecordRepository issuedRepo,
            EmployeeProfileRepository employeeRepo,
            DeviceCatalogItemRepository deviceRepo
    ) {
        this.issuedRepo = issuedRepo;
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {

        if (record.getEmployeeId() == null) {
            throw new BadRequestException("EmployeeId is required");
        }

        record.setStatus("ISSUED");
        record.setActive(true);
        record.setIssuedAt(LocalDateTime.now());
        record.setReturnedDate(null);

        return issuedRepo.save(record);
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long recordId) {

        IssuedDeviceRecord record = issuedRepo.findById(recordId)
                .orElseThrow(() -> new BadRequestException("Issued record not found"));

        // ✅ FIX: Cover ALL "already returned" cases
        if (!record.isActive()
                || "RETURNED".equalsIgnoreCase(record.getStatus())
                || record.getReturnedDate() != null) {
            throw new BadRequestException("Device already returned");
        }

        record.setStatus("RETURNED");
        record.setActive(false);
        record.setReturnedDate(LocalDateTime.now());

        return issuedRepo.save(record);
    }

    @Override
    public List<IssuedDeviceRecord> getAll() {
        return issuedRepo.findAll();
    }

    @Override
    public List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId) {
        return issuedRepo.findByEmployeeId(employeeId);
    }
}
