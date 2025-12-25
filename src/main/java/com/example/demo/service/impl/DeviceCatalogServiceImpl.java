package com.example.demo.service.impl;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    private final DeviceCatalogItemRepository repository;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceCatalogItem save(DeviceCatalogItem item) {
        return repository.save(item);
    }

    @Override
    public Optional<DeviceCatalogItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DeviceCatalogItem> findAll() {
        return repository.findAll();
    }
}
