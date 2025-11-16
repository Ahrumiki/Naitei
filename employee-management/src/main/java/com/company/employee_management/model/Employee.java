package com.company.employee_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dùng 'name' theo yêu cầu lab 4
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Đây là mối quan hệ chính
    // @ManyToOne: Nhiều Employee thuộc về Một Department
    @ManyToOne(fetch = FetchType.EAGER) // EAGER để luôn tải thông tin Department
    @JoinColumn(name = "department_id") // Tên cột khóa ngoại trong bảng 'employees'
    private Department department;

    // Getters and Setters...
    // (Dùng Alt + Insert để tạo nhanh)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}