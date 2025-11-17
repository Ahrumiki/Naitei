package com.company.employee_management.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        System.out.println("System running at: " + LocalDateTime.now());
    }

    @Scheduled(fixedRate = 60000)
    @CacheEvict(value = "total_employees", allEntries = true)
    public void clearEmployeeCache() {
        System.out.println("Cache 'total_employees' has been cleared at: " + LocalDateTime.now());
    }
}