package com.example.demo.service;

import com.example.demo.entity.DeviceCatalogItem;

public interface DeviceCatalogService {
    DeviceCatalogItem getByDeviceCode(String deviceCode);
}
