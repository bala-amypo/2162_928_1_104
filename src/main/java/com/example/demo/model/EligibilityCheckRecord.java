package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    // TEST EXPECTS deviceItemId (not deviceId)
    private Long deviceItemId;

    private Boolean isEligible;

    private String reason;

    private LocalDateTime checkedAt;

    @PrePersist
    public void prePersist() {
        if (checkedAt == null) {
            checkedAt = LocalDateTime.now();
        }
    }

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getDeviceItemId() {
        return deviceItemId;
    }

    public Boolean getIsEligible() {
        return isEligible;
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

    public void setDeviceItemId(Long deviceItemId) {
        this.deviceItemId = deviceItemId;
    }

    public void setIsEligible(Boolean eligible) {
        this.isEligible = eligible;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
