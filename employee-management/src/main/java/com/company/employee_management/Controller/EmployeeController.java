package com.company.employee_management.Controller;

import com.company.employee_management.model.Employee; // Import model
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Import các annotation

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController

@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();
    public EmployeeController() {
        employeeList.add(new Employee(counter.incrementAndGet(), "John", "Doe", "john.doe@example.com", "IT"));
        employeeList.add(new Employee(counter.incrementAndGet(), "Jane", "Smith", "jane.smith@example.com", "HR"));
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
        newEmployee.setId(counter.incrementAndGet());

        employeeList.add(newEmployee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
}