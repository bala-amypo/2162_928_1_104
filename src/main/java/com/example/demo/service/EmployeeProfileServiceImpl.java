package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.EmployeeProfile;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        employee.setActive(true);
        return employee;
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        EmployeeProfile emp = new EmployeeProfile();
        emp.setId(id);
        return emp;
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, boolean active) {
        EmployeeProfile emp = new EmployeeProfile();
        emp.setId(id);
        emp.setActive(active);
        return emp;
    }
}
