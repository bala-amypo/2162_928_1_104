package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    // ✅ Constructor Injection
    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    // ✅ POST – Create Device Catalog Item
    @PostMapping
    public DeviceCatalogItem createDevice(@RequestBody DeviceCatalogItem item) {
        return service.createItem(item);
    }

    // ✅ PUT – Activate / Deactivate Device
    // Example: PUT /api/devices/1/active?active=false
    @PutMapping("/{id}/active")
    public DeviceCatalogItem updateDeviceStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return service.updateActiveStatus(id, active);
    }

    // ✅ GET – Fetch All Devices
    @GetMapping
    public List<DeviceCatalogItem> getAllDevices() {
        return service.getAllItems();
    }
}
