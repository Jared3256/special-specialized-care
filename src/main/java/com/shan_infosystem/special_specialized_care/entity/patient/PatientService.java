package com.shan_infosystem.special_specialized_care.entity.patient;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

public interface PatientService
{
    ResponseEntity<Patient> findPatientById(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<String> registerNewPatient(Patient patient) throws Entity_Found_Exception;

    ResponseEntity<String> deletePatientById(long id) throws Entity_Not_Found_Exception;
}
