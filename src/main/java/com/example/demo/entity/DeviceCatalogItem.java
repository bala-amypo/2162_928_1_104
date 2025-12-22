package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "device_catalog_item")
public class DeviceCatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String deviceCode;

    private String deviceType;
    private String model;

    private Integer maxAllowedPerEmployee;
    private Boolean active;

    public DeviceCatalogItem() {}
}
