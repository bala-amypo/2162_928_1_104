package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long deviceId;

    private Boolean isEligible;

    private String reason;

    private LocalDateTime checkedAt;

    @PrePersist
    public void prePersist() {
        this.checkedAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    // 🔴 REQUIRED EXACT NAME
    public Boolean getIsEligible() {
        return isEligible;
    }

    // 🔴 REQUIRED EXACT NAME
    public void setIsEligible(Boolean eligible) {
        isEligible = eligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
}
