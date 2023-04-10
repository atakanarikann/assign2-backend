package com.employee.management.employee.management.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.employee.management.employee.management.entity.User;
import com.employee.management.employee.management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    public Mutation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(String username, String firstname, String lastname, String email) {
        User employee = new User();
        employee.setUsername(username);
        employee.setFirstname(firstname);
        employee.setEmail(email);
        employee.setLastname(lastname);
        employee.setRole("employee");
        employee.setPassword(passwordEncoder.encode("1234"));
        return userRepository.save(employee);
    }

    public User update(Long id, String username, String firstname, String lastname, String email) {
        User employee = userRepository.findById(id).orElseThrow(NullPointerException::new);

        if (username != null){
            employee.setUsername(username);
        }
        if (firstname != null) {
            employee.setFirstname(firstname);
        }
        if (lastname != null) {
            employee.setLastname(lastname);
        }
        if (email != null) {
            employee.setEmail(email);
        }

        return userRepository.save(employee);
    }

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }


    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

}


