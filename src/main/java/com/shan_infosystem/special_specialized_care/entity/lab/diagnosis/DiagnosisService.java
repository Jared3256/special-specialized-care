package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiagnosisService
{
    ResponseEntity<PatientDiagnosis> findPatientDiagnosisById(long id) throws Entity_Not_Found_Exception;

    List<PatientDiagnosis> findAllPatientDiagnoses() throws Entity_Not_Found_Exception;

    List<PatientDiagnosis> findAllDiagnosisByPatientId(long patientID) throws Entity_Not_Found_Exception;

    ResponseEntity<PatientDiagnosis> findByDiagnosisIdAndPatientId(long patientId, long dId) throws Entity_Not_Found_Exception;

    ResponseEntity<String> addPatientDiagnosis(PatientDiagnosis patientDiagnosis) throws Entity_Not_Found_Exception, Entity_Found_Exception;
}
