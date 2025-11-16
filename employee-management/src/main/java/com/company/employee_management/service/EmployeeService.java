package com.company.employee_management.service;

import com.company.employee_management.model.Department;
import com.company.employee_management.model.Employee;
import com.company.employee_management.repository.DepartmentRepository;
import com.company.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // === CRUD ===

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee, Long departmentId) {
        // Tìm department
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Error: Department not found."));
        // Gán department cho employee
        employee.setDepartment(department);
        // Lưu employee
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Employee not found."));

        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        // (Bạn có thể thêm logic cập nhật department nếu muốn)

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // === TÌM KIẾM ===

    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> searchEmployeesByDepartment(String deptName) {
        return employeeRepository.findByDepartmentNameContainingIgnoreCase(deptName);
    }
}