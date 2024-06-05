package com.shan_infosystem.special_specialized_care.entity.patient;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{

    @Autowired
    private PatientRepository patientRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Patient> findPatientById(long id) throws Entity_Not_Found_Exception
    {
        Optional<Patient> patientOptional = patientRepository.findById(id);

        if (patientOptional.isEmpty())
            throw new Entity_Not_Found_Exception("Patient with Id " + id + " is not found");

        return ResponseEntity.ok(patientOptional.get());
    }

    /**
     * @param patient
     * @return
     */
    @Override
    public ResponseEntity<String> registerNewPatient(Patient patient) throws Entity_Found_Exception
    {
        Optional<Patient> optionalPatient = patientRepository.findByNameAndFamilyUnit(patient.getName(), patient.getFamilyUnit());

        if (optionalPatient.isPresent())
            throw new Entity_Found_Exception("Patient is Already registered");

        patientRepository.save(patient);

        return ResponseEntity.ok("Client Registered Successfully");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deletePatientById(long id) throws Entity_Not_Found_Exception
    {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isEmpty())
            throw new Entity_Not_Found_Exception("Unable to delete the patient with Id " + id);

        patientRepository.deleteById(id);
        
        return ResponseEntity.ok("Patient Removed Successfully");
    }
}
