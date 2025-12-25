package com.example.demo.service.impl;

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
    public EmployeeProfile save(EmployeeProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeProfile getEmployeeById(long id) {
        return repository.findById(id).orElse(null);
    }
}
