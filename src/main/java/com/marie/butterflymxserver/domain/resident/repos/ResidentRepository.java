package com.marie.butterflymxserver.domain.resident.repos;

import com.marie.butterflymxserver.domain.resident.models.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Optional<Resident> findByEmail(String email);
}
