package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String employeeId;

    private String fullName;
    private String email;
    private String department;
    private String jobRole;

    private Boolean active = true;

    private LocalDateTime createdAt;

    // Tests expect String storage (email/username)
    private String createdBy;

    // ================= CONSTRUCTORS =================

    public EmployeeProfile() {}

    // REQUIRED BY TESTS
    public EmployeeProfile(
            String employeeId,
            String fullName,
            String email,
            String department,
            String jobRole,
            UserAccount createdBy
    ) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.jobRole = jobRole;
        this.createdBy = createdBy != null ? createdBy.getEmail() : null;
    }

    // ================= JPA =================

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    // REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // REQUIRED BY TESTS
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    // REQUIRED BY TESTS
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // REQUIRED BY TESTS
    public void setCreatedBy(UserAccount userAccount) {
        if (userAccount != null) {
            this.createdBy = userAccount.getEmail();
        }
    }
}
