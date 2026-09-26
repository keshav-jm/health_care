package com.example.healthcare.config;

import com.example.healthcare.Repository.UserRepository;
import com.example.healthcare.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByEmail("admin@healthcore.org").isEmpty()) {
                userRepository.save(new User("admin@healthcore.org", "admin123", "ADMIN", "Keshav J."));
            }
            if (userRepository.findByEmail("doctor@healthcore.org").isEmpty()) {
                userRepository.save(new User("doctor@healthcore.org", "doctor123", "DOCTOR", "Dr. Suresh Kumar"));
            }
            if (userRepository.findByEmail("patient@healthcore.org").isEmpty()) {
                userRepository.save(new User("patient@healthcore.org", "patient123", "PATIENT", "Anitha Raj"));
            }
        };
    }
}