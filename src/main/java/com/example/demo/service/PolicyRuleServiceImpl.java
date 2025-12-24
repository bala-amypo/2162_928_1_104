package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PolicyRule;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    public PolicyRuleServiceImpl() {
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        rule.setActive(true);
        return rule;
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return new ArrayList<>();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return new ArrayList<>();
    }
}
