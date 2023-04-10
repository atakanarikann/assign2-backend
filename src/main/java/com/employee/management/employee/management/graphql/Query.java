package com.employee.management.employee.management.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.employee.management.employee.management.entity.User;
import com.employee.management.employee.management.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    public Query(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
