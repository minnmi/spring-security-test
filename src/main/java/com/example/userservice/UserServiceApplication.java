package com.example.userservice;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import com.example.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService appUserService) {
        return args -> {

            appUserService.saveRole(new Role(null, "ROLE_USER"));
            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            appUserService.saveUser(new AppUser(null, "John Doe", "john", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Jane Doe", "jane", "1232", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "John Two", "johntwo", "1234", new ArrayList<>()));
            appUserService.saveUser(new AppUser(null, "Jane Two", "janetwo", "1234", new ArrayList<>()));

            appUserService.addRoleToUser("john", "ROLE_USER");
            appUserService.addRoleToUser("john", "ROLE_MANAGER");
            appUserService.addRoleToUser("jane", "ROLE_MANAGER");
            appUserService.addRoleToUser("johntwo", "ROLE_ADMIN");
            appUserService.addRoleToUser("janetwo", "ROLE_SUPER_ADMIN");
            appUserService.addRoleToUser("janetwo", "ROLE_ADMIN");
            appUserService.addRoleToUser("janetwo", "ROLE_USER");
        };

    }

}


