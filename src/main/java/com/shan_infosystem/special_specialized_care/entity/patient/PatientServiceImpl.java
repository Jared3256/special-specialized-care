package com.shan_infosystem.special_specialized_care.entity.patient;

import com.shan_infosystem.special_specialized_care.entity.family_unit.Family;
import com.shan_infosystem.special_specialized_care.entity.family_unit.FamilyRepository;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.entity.model.PatientModel;
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
    private Mapper mapper;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private FamilyRepository familyRepository;

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
    public ResponseEntity<String> registerNewPatient(PatientModel patient) throws Entity_Found_Exception
    {
        mapper = new Mapper();
        Optional<Patient> optionalPatient =
                patientRepository.findByNameAndFamilyUnit(patient.getName(), patient.getFamilyUnitCode());

        if (optionalPatient.isPresent())
            throw new Entity_Found_Exception("Patient is Already registered");

        Optional<Family> optionalFamily = familyRepository.findById(patient.getFamilyUnitCode());

        if (optionalFamily.isEmpty())
            throw new Entity_Found_Exception("Cannot associate patient to non-existing family");

        Patient patient1 = mapper.toPatient(patient, optionalFamily.get());

        patientRepository.save(patient1);

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
