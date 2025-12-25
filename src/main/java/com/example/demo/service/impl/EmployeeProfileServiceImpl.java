package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        return repo.save(employee);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = repo.findById(id).orElseThrow();
        emp.setActive(active);
        return repo.save(emp);
    }
}
