package com.shan_infosystem.special_specialized_care.entity.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    Optional<Patient> findByNameAndFamilyUnit(String name, long familyUnit);
}
