package com.company.employee_management.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity // Đánh dấu đây là một Entity
@Table(name = "employees") // Tên của bảng trong database
public class Employee {

    @Id // Đánh dấu đây là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Long id;

    // @Column dùng để tùy chỉnh cột (ví dụ: không được null, độ dài...)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    // Cần một constructor rỗng cho JPA
    public Employee() {
    }

    // Constructor có tham số (dùng để tạo đối tượng mới)
    public Employee(String firstName, String lastName, String email, String department, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
    }

    // Thêm Getter và Setter cho tất cả các trường
    // (Bạn có thể dùng tính năng "Generate" của IntelliJ: Alt + Insert)

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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
