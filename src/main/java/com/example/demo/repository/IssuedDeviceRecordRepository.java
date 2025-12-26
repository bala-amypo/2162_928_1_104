package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    @Query("""
        SELECT COUNT(r) FROM IssuedDeviceRecord r
        WHERE r.employee.id = :employeeId AND r.active = true
    """)
    long countActiveDevicesForEmployee(long employeeId);

    @Query("""
        SELECT r FROM IssuedDeviceRecord r
        WHERE r.employee.id = :employeeId
          AND r.deviceItem.id = :deviceItemId
          AND r.active = true
    """)
    List<IssuedDeviceRecord> findActiveByEmployeeAndDevice(long employeeId, long deviceItemId);
}
