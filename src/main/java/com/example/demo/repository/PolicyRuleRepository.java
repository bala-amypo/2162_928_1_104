package com.example.demo.repository;

import com.example.demo.model.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {

    // REQUIRED BY TESTS
    List<PolicyRule> findByActiveTrue();

    // REQUIRED BY TESTS
    Optional<PolicyRule> findByRuleCode(String ruleCode);
}
