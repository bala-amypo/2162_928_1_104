package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

    // REQUIRED BY TESTS
    Optional<EmployeeProfile> findByEmail(String email);

    // REQUIRED BY TESTS (YES, STRING – test uses String)
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
