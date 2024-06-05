package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<PatientDiagnosis, Long>
{
}
