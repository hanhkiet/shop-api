package com.vti.group1.shopapi.auth;

import com.vti.group1.shopapi.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class ManagerDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;
    @Override
    public ManagerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerRepository.findByUsername(username)
                .map(ManagerDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
