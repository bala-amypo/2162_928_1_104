package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController {

    private final DeviceCatalogService service;

    public DeviceCatalogController(DeviceCatalogService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public DeviceCatalogItem get(@PathVariable String code) {
        return service.getByDeviceCode(code);
    }
}
