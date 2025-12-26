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

    // Stored as STRING in DB
    private String createdBy;

    public EmployeeProfile() {}

    // ✅ ONLY constructor
    public EmployeeProfile(
            String employeeId,
            String fullName,
            String email,
            String department,
            String jobRole,
            Object createdBy
    ) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.jobRole = jobRole;
        setCreatedBy(createdBy);
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // ===== GETTERS =====
    public Long getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getJobRole() { return jobRole; }
    public Boolean getActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getCreatedBy() { return createdBy; }

    // ===== SETTERS =====
    public void setId(Long id) { this.id = id; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setJobRole(String jobRole) { this.jobRole = jobRole; }
    public void setActive(Boolean active) { this.active = active; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // 🔥 ONLY setter (no String version)
    public void setCreatedBy(Object createdBy) {
        if (createdBy instanceof UserAccount) {
            this.createdBy = ((UserAccount) createdBy).getEmail();
        } else if (createdBy instanceof String) {
            this.createdBy = (String) createdBy;
        } else {
            this.createdBy = null;
        }
    }
}
