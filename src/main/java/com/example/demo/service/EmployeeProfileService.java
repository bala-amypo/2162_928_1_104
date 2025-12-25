package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    // REQUIRED BY TESTS
    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile updateEmployeeStatus(long employeeId, boolean active);

    EmployeeProfile getEmployeeById(long id);

    List<EmployeeProfile> getAllEmployees();
}
