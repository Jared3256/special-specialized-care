package com.shan_infosystem.special_specialized_care.controller.lab;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.DiagnosisService;
import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.PatientDiagnosis;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sphcs/lab/g")
public class LabGetController
{
    private static final Logger logger = LoggerFactory.getLogger(LabGetController.class);

    @Autowired
    private DiagnosisService diagnosisService;

    /**
     * Find specific diagnosis with the provided id
     *
     * @param id
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/diagnosis/find")
    public ResponseEntity<PatientDiagnosis> findPatientDiagnosisById(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding Diagnosis for Id " + id);
        return diagnosisService.findPatientDiagnosisById(id);
    }

    /**
     * Find all Patient diagnoses
     *
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/diagnosis/find_all")
    public List<PatientDiagnosis> findAllPatientDiagnosis() throws Entity_Not_Found_Exception
    {
        logger.warn("Finding all Patient diagnoses");
        return diagnosisService.findAllPatientDiagnoses();
    }

    /**
     * Find all Diagnosis from a particular patient
     *
     * @param patientID
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/diagnosis/find_all_by_patient_id")
    public List<PatientDiagnosis> findAllDiagnosisByPatientId(@RequestParam(name = "id") long patientID) throws Entity_Not_Found_Exception
    {
        logger.info("finding all diagnoses for patient of id " + patientID);
        return diagnosisService.findAllDiagnosisByPatientId(patientID);
    }

    /**
     * Filter by dId provided and patient patientId
     *
     * @param patientId
     * @param dId
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/diagnosis/find_by_patient_id")
    public ResponseEntity<PatientDiagnosis> findByDiagnosisIdAndPatientId(
            @RequestParam(name = "patientId") long patientId,
            @RequestParam(name = "diagnosisId") long dId
    ) throws Entity_Not_Found_Exception
    {
        logger.info("Find diagnosis for patient Id " + patientId + " and diagnosis " + dId);
        return diagnosisService.findByDiagnosisIdAndPatientId(patientId, dId);
    }
}
