package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssuedDeviceRecordRepository
        extends JpaRepository<IssuedDeviceRecord, Long> {

    @Query("""
        SELECT i FROM IssuedDeviceRecord i
        WHERE i.employeeId = :employeeId
        AND i.deviceId = :deviceItemId
        AND i.active = true
    """)
    List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(long employeeId, long deviceItemId);

    @Query("""
        SELECT COUNT(i) FROM IssuedDeviceRecord i
        WHERE i.employeeId = :employeeId
        AND i.active = true
    """)
    long countActiveDevicesForEmployee(long employeeId);
}
