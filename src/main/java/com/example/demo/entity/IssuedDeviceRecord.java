package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issued_device_record")
public class IssuedDeviceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long deviceItemId;

    private LocalDate issuedDate;
    private LocalDate returnedDate;

    private String status; // ISSUED / RETURNED

    public IssuedDeviceRecord() {}
}
