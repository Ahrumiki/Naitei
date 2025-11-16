package com.company.employee_management.Controller;

import com.company.employee_management.service.UtilityService; // Import service
import org.springframework.security.crypto.password.PasswordEncoder; // Import bean
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final UtilityService utilityService;
    private final PasswordEncoder passwordEncoder;

    public HelloController(UtilityService utilityService,
                           PasswordEncoder passwordEncoder) {
        this.utilityService = utilityService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/hello")
    public String sayHello() {
        String newEmployeeId = utilityService.generateEmployeeId();

        String rawPassword = "mysecretpassword123";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        return "Project đã chạy thành công!<br>" +
                "Mã nhân viên mới: " + newEmployeeId + "<br>" +
                "Mật khẩu thô: " + rawPassword + "<br>" +
                "Mật khẩu đã mã hóa: " + encodedPassword;
    }
}