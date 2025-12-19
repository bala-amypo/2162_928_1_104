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
    public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public EmployeeProfile get(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateEmployeeStatus(id, active);
    }
}
