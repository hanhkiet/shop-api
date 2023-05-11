package com.vti.group1.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.group1.shopapi.entity.BlacklistToken;

public interface BlacklistTokenRepository extends JpaRepository<BlacklistToken, String> {

    boolean existsByToken(String token);
}
