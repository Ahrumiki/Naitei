package com.company.employee_management.service;

import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
public class UtilityService {

    public String generateEmployeeId() {
        return "EMP-" + UUID.randomUUID().toString();
    }

    public String normalizeString(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        return input.trim().toLowerCase();
    }
}