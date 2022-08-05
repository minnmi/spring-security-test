package com.example.userservice.repositories;

import com.example.userservice.domain.AppUser;
import com.example.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
