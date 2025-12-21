package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.DeviceCatalogItem;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {
        item.setActive(true);
        return item;
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, boolean active) {
        DeviceCatalogItem item = new DeviceCatalogItem();
        item.setId(id);
        item.setActive(active);
        return item;
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return new ArrayList<>();
    }
}
