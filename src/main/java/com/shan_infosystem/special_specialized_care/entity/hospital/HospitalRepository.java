package com.shan_infosystem.special_specialized_care.entity.hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>
{
    Optional<Hospital> findByNameAndLocation(String name, String location);
}
