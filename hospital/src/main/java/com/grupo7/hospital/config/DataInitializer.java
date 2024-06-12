package com.grupo7.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.grupo7.hospital.model.User;
import com.grupo7.hospital.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByEmail("admin@admin.com") == null) {
                User admin = new User();
                admin.setEmail("admin@admin.com");
                admin.setHashSenha(passwordEncoder.encode("@@@@"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}
