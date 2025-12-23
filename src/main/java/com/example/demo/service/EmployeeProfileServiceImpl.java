package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    // ✅ Constructor Injection (MANDATORY as per spec)
    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    // ✅ Create Employee
    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {

        // Duplicate employeeId check
        if (repository.findByEmployeeId(employee.getEmployeeId()).isPresent()) {
            throw new BadRequestException("EmployeeId already exists");
        }

        employee.setActive(true);
        employee.setCreatedAt(LocalDateTime.now());

        return repository.save(employee);
    }

    // ✅ Get Employee by DB ID
    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    // ✅ Activate / Deactivate Employee
    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile employee = getEmployeeById(id);
        employee.setActive(active);
        return repository.save(employee);
    }
}
