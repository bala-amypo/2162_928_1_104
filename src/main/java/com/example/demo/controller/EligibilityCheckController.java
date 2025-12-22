package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityCheckController {

    private final EligibilityCheckService service;

    public EligibilityCheckController(EligibilityCheckService service) {
        this.service = service;
    }

    @PostMapping
    public EligibilityCheckRecord checkEligibility(
            @RequestParam Long employeeId,
            @RequestParam Long deviceItemId) {

        return service.validateEligibility(employeeId, deviceItemId);
    }

    @GetMapping
    public List<EligibilityCheckRecord> getAll() {
        return service.getAll();
    }
}
