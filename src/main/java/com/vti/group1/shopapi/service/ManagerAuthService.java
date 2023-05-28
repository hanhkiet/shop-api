package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.ManagerDataDto;
import com.vti.group1.shopapi.entity.Manager;
import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.ManagerRepository;
import com.vti.group1.shopapi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerAuthService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdmin() {
        User admin = User.builder().username("admin").password(passwordEncoder.encode("superadmin"))
                .role(Role.MANAGER).build();

        Manager manager = Manager.builder().firstName("Admin").lastName("Admin").user(admin)
                .build();

        managerRepository.save(manager);
    }


    public ManagerDataDto login(CredentialsDto credentialsDto) {
        String username = credentialsDto.getUsername();
        String password = credentialsDto.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Invalid credentials");
        }

        Manager manager = managerRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Manager not found"));

        return ManagerDataDto.builder().uuid(manager.getUuid()).firstName(manager.getFirstName())
                .lastName(manager.getLastName()).username(user.getUsername()).build();
    }
}
