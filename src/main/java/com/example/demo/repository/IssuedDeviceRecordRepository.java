package com.example.demo.repository;

import com.example.demo.model.IssuedDeviceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IssuedDeviceRecordRepository
        extends JpaRepository<IssuedDeviceRecord, Long> {

    List<IssuedDeviceRecord> findByEmployeeId(Long employeeId);

    @Query("SELECT COUNT(i) FROM IssuedDeviceRecord i WHERE i.employeeId = :employeeId")
    long countActiveDevicesForEmployee(long employeeId);

    @Query("SELECT i FROM IssuedDeviceRecord i WHERE i.employeeId = :employeeId AND i.deviceId = :deviceId")
    Optional<IssuedDeviceRecord> findActiveByEmployeeAndDevice(long employeeId, long deviceId);
}
