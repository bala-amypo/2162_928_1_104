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

    private Boolean eligible;

    private String reason;

    private LocalDateTime checkedAt;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public Boolean getEligible() {
        return eligible;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    // ===== SETTERS =====

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
