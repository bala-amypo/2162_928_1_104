package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile save(EmployeeProfile profile);

    List<EmployeeProfile> getAllEmployees();

    // REQUIRED BY TESTS
    EmployeeProfile getEmployeeById(long id);
}
