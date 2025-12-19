package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile emp) {
        return service.createEmployee(emp);
    }
}
