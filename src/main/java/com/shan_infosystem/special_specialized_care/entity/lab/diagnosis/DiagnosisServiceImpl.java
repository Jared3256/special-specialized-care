package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import com.shan_infosystem.special_specialized_care.entity.patient.Patient;
import com.shan_infosystem.special_specialized_care.entity.patient.PatientRepository;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService
{
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private PatientRepository patientRepository;

    /**
     * @param id
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public ResponseEntity<PatientDiagnosis> findPatientDiagnosisById(long id) throws Entity_Not_Found_Exception
    {
        Optional<PatientDiagnosis> optionalPatientDiagnosis = diagnosisRepository.findById(id);

        if (optionalPatientDiagnosis.isEmpty())
            throw new Entity_Not_Found_Exception("No Diagnosis found with that Id");

        return ResponseEntity.ok(optionalPatientDiagnosis.get());
    }

    /**
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public List<PatientDiagnosis> findAllPatientDiagnoses() throws Entity_Not_Found_Exception
    {
        List<PatientDiagnosis> patientDiagnoses = diagnosisRepository.findAll();
        if (patientDiagnoses.isEmpty())
            throw new Entity_Not_Found_Exception("NO Diagnosis found ");

        return patientDiagnoses;
    }

    /**
     * @param patientID
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public List<PatientDiagnosis> findAllDiagnosisByPatientId(long patientID) throws Entity_Not_Found_Exception
    {
        Optional<Patient> optionalPatient = patientRepository.findById(patientID);

        if (optionalPatient.isEmpty())
            throw new Entity_Not_Found_Exception("NO Patient is found with Id " + patientID);

        List<PatientDiagnosis> patientDiagnoses = diagnosisRepository.findAllByPatientId(patientID);

        if (patientDiagnoses.isEmpty())
            throw new Entity_Not_Found_Exception("Patient [ " + optionalPatient.get().getName() + " ] has no diagnoses yet");


        return patientDiagnoses;
    }

    /**
     * @param patientId
     * @param dId
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public ResponseEntity<PatientDiagnosis> findByDiagnosisIdAndPatientId(long patientId, long dId) throws Entity_Not_Found_Exception
    {
        List<PatientDiagnosis> patientDiagnoses = findAllDiagnosisByPatientId(patientId);

        Optional<PatientDiagnosis> patientDiagnosis = patientDiagnoses
                .stream()
                .filter(pd -> pd.getDiagnosisId() == dId).findAny();

        if (patientDiagnosis.isEmpty())
            throw new Entity_Not_Found_Exception("NO Diagnosis found for the provided Id");

        return ResponseEntity.ok(patientDiagnosis.get());
    }

    /**
     * @param patientDiagnosis
     * @return
     * @throws Entity_Not_Found_Exception
     * @throws Entity_Found_Exception
     */
    @Override
    public ResponseEntity<String> addPatientDiagnosis(PatientDiagnosis patientDiagnosis) throws Entity_Not_Found_Exception, Entity_Found_Exception
    {
        Optional<Patient> optionalPatient = patientRepository.findById(patientDiagnosis.getPatientId());

        if (optionalPatient.isEmpty())
            throw new Entity_Not_Found_Exception("Cannot Add Diagnosis to non-existing Patient ");

        Optional<PatientDiagnosis> patientDiagnosis1 = diagnosisRepository.findByPatientIdAndDiagnosisDate(
                patientDiagnosis.getPatientId(), patientDiagnosis.getDiagnosisDate());

        if (patientDiagnosis1.isPresent())
            throw new Entity_Found_Exception("Diagnosis is Already saved");

        diagnosisRepository.save(patientDiagnosis);
        return ResponseEntity.ok("Patient Diagnosis Saved successfully");
    }
}
