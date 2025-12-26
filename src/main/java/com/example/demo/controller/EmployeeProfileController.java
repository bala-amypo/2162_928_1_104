package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") // ✅ REQUIRED PATH
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    // POST /api/employees
    @PostMapping
    public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
        return service.createEmployee(employee);
    }

    // GET /api/employees/{id}
    @GetMapping("/{id}")
    public EmployeeProfile getById(@PathVariable long id) {
        return service.getEmployeeById(id);
    }

    // GET /api/employees
    @GetMapping
    public List<EmployeeProfile> getAll() {
        return service.getAllEmployees();
    }

    // PUT /api/employees/{id}/status
    @PutMapping("/{id}/status")
    public EmployeeProfile updateStatus(
            @PathVariable long id,
            @RequestParam boolean active
    ) {
        return service.updateEmployeeStatus(id, active);
    }
}
