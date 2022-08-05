package com.example.userservice.controllers.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RoleToUserForm {

        private String username;
        private String roleName;

}
