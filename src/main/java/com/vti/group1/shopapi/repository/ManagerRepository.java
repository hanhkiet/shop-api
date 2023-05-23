package com.vti.group1.shopapi.repository;

import com.vti.group1.shopapi.entity.Manager;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Optional<Manager> findByUsername(String username);
}
