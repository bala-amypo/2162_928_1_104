package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.EmployeeProfile;
import com.example.demo.service.EmployeeProfileServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileServiceImpl service;

    public EmployeeProfileController(EmployeeProfileServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
        return service.create(employee);
    }
}
