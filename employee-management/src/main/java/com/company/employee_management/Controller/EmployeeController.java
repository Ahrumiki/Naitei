package com.company.employeemanagement.controller;

import com.company.employee_management.model.Employee;
import com.company.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // Tiêm Service

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee,
                                                   @RequestParam Long departmentId) {
        Employee createdEmployee = employeeService.createEmployee(employee, departmentId);
        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        // Gọi service thay vì list in-memory
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @Valid @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department) {

        if (name != null) {
            return employeeService.searchEmployeesByName(name);
        }
        if (department != null) {
            return employeeService.searchEmployeesByDepartment(department);
        }
        return employeeService.getAllEmployees();
    }
    @GetMapping("/count")
    public Long countTotalEmployees() {
        return employeeService.countEmployees();
    }
}