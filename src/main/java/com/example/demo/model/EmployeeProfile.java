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

    @Column(unique = true)
    private String email;

    private String department;
    private String jobRole;

    private Boolean active = true;

    private LocalDateTime createdAt;

    // ✅ Stored as STRING (what DB + JSON expect)
    private String createdBy;

    public EmployeeProfile() {}

    // ✅ Constructor used by YOUR code
    public EmployeeProfile(
            String employeeId,
            String fullName,
            String email,
            String department,
            String jobRole,
            String createdBy
    ) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.jobRole = jobRole;
        this.createdBy = createdBy;
    }

    // ✅ Constructor used by TEST SUITE (VERY IMPORTANT)
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

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getJobRole() { return jobRole; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getCreatedBy() { return createdBy; }

    // ✅ Setter used by YOUR services
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // ✅ Setter used by TEST SUITE
    public void setCreatedBy(UserAccount createdBy) {
        this.createdBy = createdBy != null ? createdBy.getEmail() : null;
    }
}
