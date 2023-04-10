package com.employee.management.employee.management.service;

import com.employee.management.employee.management.dto.UserDto;
import com.employee.management.employee.management.entity.User;

public interface UserService {

    User register(UserDto userDto);
}
