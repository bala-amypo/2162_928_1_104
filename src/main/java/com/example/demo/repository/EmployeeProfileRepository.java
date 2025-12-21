package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.entity.EmployeeProfile;

public interface EmployeeProfileRepository {
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
