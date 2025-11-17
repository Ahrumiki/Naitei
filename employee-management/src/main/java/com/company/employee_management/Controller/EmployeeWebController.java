package com.company.employee_management.Controller;

import com.company.employee_management.model.Department;
import com.company.employee_management.model.Employee;
import com.company.employee_management.service.EmployeeService;
import com.company.employee_management.repository.DepartmentRepository; // Để lấy danh sách phòng ban
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Quan trọng: Dùng @Controller cho Web MVC
@RequestMapping("/employees")
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    // 1. Hiển thị danh sách nhân viên + Tìm kiếm
    @GetMapping("/list")
    public String listEmployees(Model model,
                                @RequestParam(required = false) String keyword) {
        List<Employee> list;

        if (keyword != null && !keyword.isEmpty()) {
            // Tìm kiếm theo tên (bạn đã viết hàm này ở Lab 4)
            list = employeeService.searchEmployeesByName(keyword);
        } else {
            list = employeeService.getAllEmployees();
        }

        // Đưa dữ liệu vào Model để Thymeleaf hiển thị
        model.addAttribute("employees", list);
        model.addAttribute("keyword", keyword); // Để giữ lại từ khóa trong ô tìm kiếm

        // Trả về tên file HTML: templates/list-employees.html
        return "list-employees";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Trả về login.html
    }
    // 2. Hiển thị Form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        // Tạo một object rỗng để bind dữ liệu từ form
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        // Lấy danh sách phòng ban để hiển thị trong dropdown (select box)
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);

        return "add-employee-form";
    }

    // 3. Xử lý khi submit Form thêm mới
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
                               @RequestParam Long departmentId) {
        // Gọi service để lưu (tái sử dụng hàm createEmployee của Lab 4)
        employeeService.createEmployee(employee, departmentId);

        // Sau khi lưu xong, chuyển hướng về trang danh sách
        return "redirect:/employees/list";
    }
}