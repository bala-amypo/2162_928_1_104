package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.PolicyRule;

public interface PolicyRuleRepository {

    List<PolicyRule> findByActiveTrue();

    Optional<PolicyRule> findByRuleCode(String ruleCode);
}
