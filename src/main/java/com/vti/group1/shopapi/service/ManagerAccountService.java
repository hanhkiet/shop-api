package com.vti.group1.shopapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.entity.Manager;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.ManagerRepository;
import com.vti.group1.shopapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerAccountService {

        private final UserRepository userRepository;
        private final ManagerRepository managerRepository;
        private final PasswordEncoder passwordEncoder;

        public AccountDto getAccount(String name) {
                User user = userRepository.findByUsername(name)
                                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found!"));

                Manager manager = managerRepository.findByUserId(user.getId())
                                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Manager not found!"));

                return AccountDto.builder().username(user.getUsername()).firstName(manager.getFirstName())
                                .lastName(manager.getLastName()).build();
        }

        public void updateAccount(AccountDto accountDto) {
                Manager manager = managerRepository.findById(accountDto.getUsername())
                                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Manager not found!"));

                manager.setFirstName(accountDto.getFirstName());
                manager.setLastName(accountDto.getLastName());

                managerRepository.save(manager);
        }

        public void updatePassword(CredentialsDto oldCredentials, CredentialsDto newCredentials) {
                User user = userRepository.findByUsername(oldCredentials.getUsername())
                                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found!"));

                if (!passwordEncoder.matches(oldCredentials.getPassword(), user.getPassword())) {
                        throw new RestException(HttpStatus.BAD_REQUEST, "Wrong password!");
                }

                user.setPassword(passwordEncoder.encode(newCredentials.getPassword()));
                userRepository.save(user);
        }
}
