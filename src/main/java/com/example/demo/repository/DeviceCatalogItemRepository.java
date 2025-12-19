package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.entity.DeviceCatalogItem;

public interface DeviceCatalogItemRepository {
    Optional<DeviceCatalogItem> findByDeviceCode(String deviceCode);
}
