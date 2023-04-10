package com.employee.management.employee.management.service.impl;

import com.employee.management.employee.management.dto.UserDto;
import com.employee.management.employee.management.entity.User;
import com.employee.management.employee.management.repository.UserRepository;
import com.employee.management.employee.management.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new RuntimeException();
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException();
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        User registerUser = new User();
        registerUser.setRole("BASIC_USER");
        registerUser.setEmail(userDto.getUsername());
        registerUser.setFirstname(userDto.getUsername());
        registerUser.setLastname(userDto.getUsername());
        registerUser.setUsername(userDto.getUsername());
        registerUser.setPassword(encodedPassword);

        return userRepository.save(registerUser);
    }
}
