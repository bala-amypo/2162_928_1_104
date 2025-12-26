package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.model.EmployeeProfile;
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

    // ✅ ISSUE DEVICE
    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record) {

        EmployeeProfile employee = employeeRepo.findById(record.getEmployee().getId())
                .orElseThrow(() -> new BadRequestException("Employee not found"));

        if (!employee.isActive()) {
            throw new BadRequestException("Employee is inactive");
        }

        DeviceCatalogItem device = deviceRepo.findById(record.getDevice().getId())
                .orElseThrow(() -> new BadRequestException("Device not found"));

        if (!device.isActive()) {
            throw new BadRequestException("Device is inactive");
        }

        record.setIssuedDate(LocalDateTime.now());
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
        record.setReturnedDate(LocalDateTime.now());
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
