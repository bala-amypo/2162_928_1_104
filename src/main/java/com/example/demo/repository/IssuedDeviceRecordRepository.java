package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    @Query("""
        SELECT COUNT(i)
        FROM IssuedDeviceRecord i
        WHERE i.employeeId = :employeeId
        AND i.status = 'ACTIVE'
    """)
    long countActiveDevicesForEmployee(long employeeId);

    @Query("""
        SELECT i
        FROM IssuedDeviceRecord i
        WHERE i.employeeId = :employeeId
        AND i.deviceItemId = :deviceItemId
        AND i.status = 'ACTIVE'
    """)
    Optional<IssuedDeviceRecord> findActiveByEmployeeAndDevice(long employeeId, long deviceItemId);

    List<IssuedDeviceRecord> findByEmployeeId(long employeeId);
}
