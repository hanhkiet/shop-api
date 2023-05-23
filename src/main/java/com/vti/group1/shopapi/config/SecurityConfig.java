package com.vti.group1.shopapi.config;

import com.vti.group1.shopapi.auth.CustomerAuthenticationProvider;
import com.vti.group1.shopapi.auth.InitialAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final CustomerAuthenticationProvider customerAuthenticationProvider;
    private final InitialAuthenticationFilter initialAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http.authorizeHttpRequests().anyRequest().permitAll();

//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()
//                .requestMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll()
//                .requestMatchers(HttpMethod.GET, "/api/v1/auth/authenticate").authenticated()
//                .requestMatchers(HttpMethod.POST, "/api/v1/auth/logout").authenticated();
//
//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll();
//        http.authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET, "/api/v1/menus/**").permitAll();
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/api/v1/account/**").authenticated();

        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authenticationProvider(customerAuthenticationProvider);

        initialAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        http.addFilterBefore(initialAuthenticationFilter, BasicAuthenticationFilter.class);

//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var cors = new CorsConfiguration();
        cors.setAllowedOrigins(List.of("*"));
        cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        cors.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
}
