package com.vti.group1.shopapi.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationManager authenticationManager;

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
//        if (email != null) {
//            var authentication = new CustomerAuthenticationToken(email, password);
//            authenticationManager.authenticate(authentication);
//            response.setHeader("Type", "Customer");
//        } else {
//            var authentication = new ManagerAuthenticationToken(username, password);
//            authenticationManager.authenticate(authentication);
//            response.setHeader("Type", "Manager");
//        }


        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }
}
