package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(long id);

    EmployeeProfile updateEmployeeStatus(long id, boolean active);

    List<EmployeeProfile> getAllEmployees();
}
