package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord, Long> {

    // REQUIRED BY TESTS
    List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);

    // REQUIRED BY TESTS
    @Query("SELECT COUNT(i) FROM IssuedDeviceRecord i WHERE i.employeeId = :employeeId AND i.status = 'ACTIVE'")
    long countActiveDevicesForEmployee(Long employeeId);

    // REQUIRED BY TESTS
    @Query("SELECT i FROM IssuedDeviceRecord i WHERE i.employeeId = :employeeId AND i.deviceId = :deviceId AND i.status = 'ACTIVE'")
    Optional<IssuedDeviceRecord> findActiveByEmployeeAndDevice(Long employeeId, Long deviceId);
}
