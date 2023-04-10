package com.employee.management.employee.management.api;

import com.employee.management.employee.management.dto.UserDto;
import com.employee.management.employee.management.entity.User;
import com.employee.management.employee.management.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDto user) {
        return userService.register(user);
    }
}