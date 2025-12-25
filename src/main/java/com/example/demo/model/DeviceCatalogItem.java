package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceCode;
    private String deviceType;
    private String model;
    private int maxAllowedPerEmployee;
    private boolean active;

    public Long getId() { return id; }
    public String getDeviceCode() { return deviceCode; }
    public void setDeviceCode(String deviceCode) { this.deviceCode = deviceCode; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getMaxAllowedPerEmployee() { return maxAllowedPerEmployee; }
    public void setMaxAllowedPerEmployee(int maxAllowedPerEmployee) { this.maxAllowedPerEmployee = maxAllowedPerEmployee; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
