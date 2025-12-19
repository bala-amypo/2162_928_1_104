package com.example.demo.repository;

public interface IssuedDeviceRecordRepository {

    long countActiveDevicesForEmployee(Long employeeId);

    boolean findActiveByEmployeeAndDevice(Long employeeId, Long deviceItemId);
}
