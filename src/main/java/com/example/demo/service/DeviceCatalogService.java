package com.example.demo.service;

import com.example.demo.model.DeviceCatalogItem;
import java.util.List;

public interface DeviceCatalogService {
    DeviceCatalogItem save(DeviceCatalogItem item);
    List<DeviceCatalogItem> getAllItems();
    DeviceCatalogItem getById(Long id);
    void deactivate(Long id);
}
