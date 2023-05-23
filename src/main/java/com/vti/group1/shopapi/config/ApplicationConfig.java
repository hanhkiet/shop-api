package com.vti.group1.shopapi.config;

import com.vti.group1.shopapi.auth.CustomerAuthenticationProvider;
import com.vti.group1.shopapi.auth.CustomerDetailsService;
import com.vti.group1.shopapi.auth.ManagerDetailsService;
import com.vti.group1.shopapi.repository.CustomerRepository;
import com.vti.group1.shopapi.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AuthenticationConfiguration authenticationConfiguration;

    private final CustomerRepository customerRepository;
    private final ManagerRepository managerRepository;

    @Bean
    public CustomerDetailsService customerDetailsService() {
        return new CustomerDetailsService(customerRepository);
    }

    @Bean
    public ManagerDetailsService managerDetailsService() {
        return new ManagerDetailsService(managerRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomerAuthenticationProvider customerAuthenticationProvider() {
        return new CustomerAuthenticationProvider(customerDetailsService(), passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
