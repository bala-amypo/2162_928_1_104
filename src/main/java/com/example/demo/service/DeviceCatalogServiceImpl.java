package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;

@Service
@Transactional
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repository;

    // ✅ Constructor injection
    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {
        item.setActive(true);

        // 🔥 THIS LINE WAS MISSING
        return repository.save(item);
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        item.setActive(active);
        return repository.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return repository.findAll();
    }
}
