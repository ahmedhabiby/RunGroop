package com.webApp.App2025.jpaReporositry;

import com.webApp.App2025.models.club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface jparepo extends JpaRepository<club, Long> {
    @Override
    Optional<club> findById(Long aLong);
}
