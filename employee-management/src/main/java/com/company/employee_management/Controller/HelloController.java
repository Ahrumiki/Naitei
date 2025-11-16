package com.company.employee_management.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController: Báo cho Spring biết đây là một Controller xử lý REST API
@RestController
public class HelloController {

    // @GetMapping("/hello"): Ánh xạ (map) request HTTP GET
    // có đường dẫn /hello vào phương thức sayHello()
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! Project đã chạy thành công!";
    }
}