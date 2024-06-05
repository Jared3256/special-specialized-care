package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<PatientDiagnosis, Long>
{
    List<PatientDiagnosis> findAllByPatientId(long patientID);

    Optional<PatientDiagnosis> findByPatientIdAndDiagnosisDate(long patientId, Instant diagnosisDate);
}
