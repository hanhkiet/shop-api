package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.entity.Token;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.TokenRepository;
import com.vti.group1.shopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public void saveToken(String username, String token) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "User not found");
        }

        tokenRepository.save(Token.builder().user(user.get()).token(token).build());
    }
}
