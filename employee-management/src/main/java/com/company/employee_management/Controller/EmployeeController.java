package com.company.employeemanagement.controller;

import com.company.employee_management.model.Employee;
import com.company.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // Tiêm Service

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee,
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
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employeeDetails) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build(); // Trả về status 204 No Content
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
}