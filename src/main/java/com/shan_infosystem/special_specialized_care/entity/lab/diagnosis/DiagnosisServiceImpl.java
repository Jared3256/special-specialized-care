package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.entity.model.PatientDiagModel;
import com.shan_infosystem.special_specialized_care.entity.patient.Patient;
import com.shan_infosystem.special_specialized_care.entity.patient.PatientRepository;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Expectation_Failed;
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
    private Mapper mapper;
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
    public ResponseEntity<String> addPatientDiagnosis(PatientDiagModel patientDiagnosis) throws Entity_Not_Found_Exception, Entity_Found_Exception
    {
        mapper = new Mapper();
        Optional<Patient> optionalPatient = patientRepository.findById(patientDiagnosis.getPatientId());

        if (optionalPatient.isEmpty())
            throw new Entity_Not_Found_Exception("Cannot Add Diagnosis to non-existing Patient ");

        Optional<PatientDiagnosis> patientDiagnosis1 = diagnosisRepository
                .findByPatientIdAndPrimaryDiagnosisAndReconsultationAdviceDate(
                        patientDiagnosis.getPatientId(),
                        patientDiagnosis.getPrimary_diagnosis(),
                        patientDiagnosis.getReconsultation_Advice_Date());

        if (patientDiagnosis1.isPresent())
            throw new Entity_Found_Exception("Diagnosis is Already saved");


        diagnosisRepository.save(mapper.toPatientDiagnosis(optionalPatient.get(), patientDiagnosis));
        return ResponseEntity.ok("Patient Diagnosis Saved successfully");
    }

    /**
     * @param diagnosisId
     * @param patientDiagModel
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public ResponseEntity<String> updateDiagnosis(long diagnosisId, PatientDiagModel patientDiagModel) throws Entity_Not_Found_Exception, Expectation_Failed
    {
        int counter = 0;

        Optional<PatientDiagnosis> patientDiagnosisOptional = diagnosisRepository.findById(diagnosisId);

        if (patientDiagnosisOptional.isEmpty())
            throw new Entity_Not_Found_Exception("Cannot update non-existing diagnosis. Check your Id");

        PatientDiagnosis patientDiagnosis = patientDiagnosisOptional.get();

        // Checks gates for update. You cannot update the patient Id and diagnosis Id
        if (patientDiagModel.getPatientId() != 0)
            throw new Expectation_Failed("You Cannot Update patient Id. Please Try again");

        if (patientDiagModel.getEcg() != null && patientDiagModel.getEcg() != patientDiagnosis.getEcg())
        {
            counter++;
            patientDiagnosis.setEcg(patientDiagModel.getEcg());
        }

        if (!patientDiagModel.getProvisional_Diagnosis().isEmpty() &&
                !patientDiagModel.getProvisional_Diagnosis().equals(patientDiagnosis.getProvisionalDiagnosis()))
        {
            counter++;
            patientDiagnosis.setProvisionalDiagnosis(patientDiagModel.getProvisional_Diagnosis());
        }

        if (!patientDiagModel.getFinalDiagnosis().isEmpty() &&
                !patientDiagModel.getFinalDiagnosis().equals(patientDiagnosis.getFinalDiagnosis()))
        {
            counter++;
            patientDiagnosis.setFinalDiagnosis(patientDiagModel.getFinalDiagnosis());
        }

        if (!patientDiagModel.getPrimary_diagnosis().isEmpty() &&
                !patientDiagModel.getPrimary_diagnosis().equals(patientDiagnosis.getPrimaryDiagnosis()))
        {
            counter++;
            patientDiagnosis.setPrimaryDiagnosis(patientDiagModel.getPrimary_diagnosis());
        }

        if (!patientDiagModel.getReconsultation_Advice_Week().isEmpty() &&
                !patientDiagModel.getReconsultation_Advice_Week().equals(patientDiagnosis.getReconsultationAdviceWeek()))
        {
            counter++;
            patientDiagnosis.setReconsultationAdviceWeek(patientDiagModel.getReconsultation_Advice_Week());
        }

        if (!patientDiagModel.getReconsultation_Advice_Date().isEmpty() &&
                !patientDiagModel.getReconsultation_Advice_Date().equals(patientDiagnosis.getReconsultationAdviceDate()))
        {
            counter++;
            patientDiagnosis.setReconsultationAdviceDate(patientDiagModel.getReconsultation_Advice_Date());
        }

        if (counter > 0)
            return ResponseEntity.ok("Patient Diagnosis updated successfully");
        else
            return ResponseEntity.ok("Patient is still up to date");
    }
}
