package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String appliesToRole;
    private String appliesToDepartment;
    private int maxDevicesAllowed;
    private boolean active = true;

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getAppliesToRole() { return appliesToRole; }
    public void setAppliesToRole(String appliesToRole) { this.appliesToRole = appliesToRole; }

    public String getAppliesToDepartment() { return appliesToDepartment; }
    public void setAppliesToDepartment(String appliesToDepartment) { this.appliesToDepartment = appliesToDepartment; }

    public int getMaxDevicesAllowed() { return maxDevicesAllowed; }
    public void setMaxDevicesAllowed(int maxDevicesAllowed) { this.maxDevicesAllowed = maxDevicesAllowed; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
