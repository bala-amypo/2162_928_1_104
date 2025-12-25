package com.example.demo.service;

import com.example.demo.entity.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {
    EmployeeProfile save(EmployeeProfile profile);
    List<EmployeeProfile> getAll();
    void updateEmployeeStatus(Long id, boolean active);
}
