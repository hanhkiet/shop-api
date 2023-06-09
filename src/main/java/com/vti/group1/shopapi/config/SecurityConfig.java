package com.vti.group1.shopapi.config;

import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final JwtService jwtService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint).and()
                .addFilterBefore(new JwtCustomerAuthenticationFilter(jwtService),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtManagerAuthenticationFilter(jwtService),
                        UsernamePasswordAuthenticationFilter.class)
                .csrf().disable().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests(requests -> requests.requestMatchers("/api/v1/customer/auth/**")
                .permitAll());

        http.authorizeHttpRequests(requests -> requests.requestMatchers("/api/v1/customer/**")
                .hasAuthority(Role.CUSTOMER.toString()));

        http.authorizeHttpRequests(requests -> requests.requestMatchers("/api/v1/manager/auth/**")
                .permitAll());

        http.authorizeHttpRequests(requests -> requests.requestMatchers("/api/v1/manager/**")
                .hasAuthority(Role.MANAGER.toString()));

        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll());

        return http.build();
    }
}
