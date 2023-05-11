package com.vti.group1.shopapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.entity.BlacklistToken;
import com.vti.group1.shopapi.repository.BlacklistTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlacklistTokenService {

    private static final Logger logger = LoggerFactory.getLogger(BlacklistTokenService.class);

    private final BlacklistTokenRepository blacklistTokenRepository;

    public void addTokenToBlacklist(String token) {

        var blacklistToken = BlacklistToken.builder()
                .token(token)
                .build();

        blacklistTokenRepository.save(blacklistToken);

        logger.info("Add token to blacklist: {}", token);
    }

    public boolean isTokenInBlacklist(String token) {
        return blacklistTokenRepository.existsById(token);
    }
}
