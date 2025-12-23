package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        employee.setActive(true);
        return repo.save(employee);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = getEmployeeById(id);
        emp.setActive(active);
        return repo.save(emp);
    }
}
