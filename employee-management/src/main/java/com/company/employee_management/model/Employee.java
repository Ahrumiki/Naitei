package com.company.employee_management.model;
import jakarta.persistence.*;
import java.time.LocalDate;
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;

    // Constructor rỗng - Rất quan trọng để Spring
    // chuyển đổi JSON thành Object (@RequestBody)
    public Employee() {
    }

    // Constructor (tùy chọn) để chúng ta tạo dữ liệu mẫu
    public Employee(Long id, String firstName, String lastName, String email, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    // --- BẮT BUỘC: Thêm Getters và Setters ---
    // Bạn có thể dùng IntelliJ (Alt + Insert -> Getter and Setter)
    // để tạo tự động cho tất cả các trường.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}