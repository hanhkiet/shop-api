package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Token;
import com.vti.group1.shopapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    boolean existsByToken(String token);

    void deleteByUser(User user);
}
