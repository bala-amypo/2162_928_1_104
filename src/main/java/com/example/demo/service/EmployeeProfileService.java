package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile employee);

    EmployeeProfile getEmployeeById(long id);

    EmployeeProfile updateEmployeeStatus(long id, boolean active);
}
