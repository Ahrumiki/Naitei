package com.company.employee_management.config;

import com.company.employee_management.model.User;
import com.company.employee_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Tạo Admin user nếu chưa có
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123")); // Mật khẩu là admin123
                admin.setRole("ROLE_ADMIN");
                userRepository.save(admin);
            }

            // Tạo Normal user nếu chưa có
            if (userRepository.findByUsername("user").isEmpty()) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123")); // Mật khẩu là user123
                user.setRole("ROLE_USER");
                userRepository.save(user);
            }
        };
    }
}