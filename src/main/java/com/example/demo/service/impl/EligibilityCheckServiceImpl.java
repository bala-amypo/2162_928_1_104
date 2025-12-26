package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {

    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository policyRepo;
    private final EligibilityCheckRecordRepository eligibilityRepo;

    public EligibilityCheckServiceImpl(
            EmployeeProfileRepository employeeRepo,
            DeviceCatalogItemRepository deviceRepo,
            IssuedDeviceRecordRepository issuedRepo,
            PolicyRuleRepository policyRepo,
            EligibilityCheckRecordRepository eligibilityRepo
    ) {
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.issuedRepo = issuedRepo;
        this.policyRepo = policyRepo;
        this.eligibilityRepo = eligibilityRepo;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {

        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);

        Optional<EmployeeProfile> empOpt = employeeRepo.findById(employeeId);
        Optional<DeviceCatalogItem> devOpt = deviceRepo.findById(deviceItemId);

        if (empOpt.isEmpty() || devOpt.isEmpty()) {
            record.setIsEligible(false);
            record.setReason("Employee or device not found");
            return eligibilityRepo.save(record);
        }

        EmployeeProfile emp = empOpt.get();
        DeviceCatalogItem dev = devOpt.get();

        if (!emp.getActive()) {
            record.setIsEligible(false);
            record.setReason("Employee not active");
            return eligibilityRepo.save(record);
        }

        if (!dev.getActive()) {
            record.setIsEligible(false);
            record.setReason("Device inactive");
            return eligibilityRepo.save(record);
        }

        if (!issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId).isEmpty()) {
            record.setIsEligible(false);
            record.setReason("Active issuance already exists");
            return eligibilityRepo.save(record);
        }

        long activeCount = issuedRepo.countActiveDevicesForEmployee(employeeId);

        if (activeCount >= dev.getMaxAllowedPerEmployee()) {
            record.setIsEligible(false);
            record.setReason("Maximum allowed devices reached");
            return eligibilityRepo.save(record);
        }

        for (PolicyRule rule : policyRepo.findByActiveTrue()) {

            boolean deptMatch = rule.getAppliesToDepartment() == null ||
                    rule.getAppliesToDepartment().equals(emp.getDepartment());

            boolean roleMatch = rule.getAppliesToRole() == null ||
                    rule.getAppliesToRole().equals(emp.getJobRole());

            if (deptMatch && roleMatch) {
                if (activeCount >= rule.getMaxDevicesAllowed()) {
                    record.setIsEligible(false);
                    record.setReason("Policy violation");
                    return eligibilityRepo.save(record);
                }
            }
        }

        record.setIsEligible(true);
        record.setReason("Eligible");
        return eligibilityRepo.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return eligibilityRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<EligibilityCheckRecord> getAll() {
        return eligibilityRepo.findAll();
    }
}
