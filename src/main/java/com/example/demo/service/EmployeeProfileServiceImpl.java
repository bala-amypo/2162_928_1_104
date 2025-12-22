package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    public EmployeeProfile create(EmployeeProfile employee) {
        employee.setActive(true);
        return repository.save(employee);
    }
}
