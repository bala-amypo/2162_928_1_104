package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    // 🔴 FIXED: use save(), NOT createEmployee()
    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile profile) {
        return service.save(profile);
    }

    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeProfile getEmployee(@PathVariable long id) {
        return service.getEmployeeById(id);
    }
}
