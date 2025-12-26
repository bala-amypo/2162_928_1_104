package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {

        // ✅ REQUIRED: Duplicate employeeId check
        repository.findByEmployeeId(employee.getEmployeeId())
                .ifPresent(e -> {
                    throw new BadRequestException("EmployeeId already exists");
                });

        return repository.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found")
                );
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return repository.save(emp);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }
}
