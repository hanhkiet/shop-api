package com.vti.group1.shopapi.auth;

import com.vti.group1.shopapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var customer = customerRepository.findByEmail(username);

        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomerDetails(customer);
    }
}
