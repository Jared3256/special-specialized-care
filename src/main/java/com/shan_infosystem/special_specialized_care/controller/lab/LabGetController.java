package com.shan_infosystem.special_specialized_care.controller.lab;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.DiagnosisService;
import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.PatientDiagnosis;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.DrugService;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.Med_Category;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.MedicationDrug;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.SideEffects;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
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
    private DrugService drugService;

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

    /**
     * Drug Related Functions
     */

    /**
     * Finding all Medication in the system
     *
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/drug/find_all")
    public List<MedicationDrug> findAllMedicationDrugs() throws Entity_Not_Found_Exception
    {
        logger.info("Finding All Medication");
        return drugService.findAllMedicationDrugs();
    }

    /**
     * Find a particular Medication with the provided id
     *
     * @param drugId
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/drug/find")
    public MedicationDrug findMedicationDrugById(@RequestParam(name = "id") long drugId) throws Entity_Not_Found_Exception
    {
        logger.info("Finding all medication for Id {}", drugId);

        return drugService.findMedicationById(drugId);
    }

    /**
     * Find all medication on the specified med_category
     *
     * @param medCategory
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/drug/find_by_category")
    public List<MedicationDrug> findMedicationByCategory(@NonNull @RequestParam(name = "category") Med_Category medCategory) throws Entity_Not_Found_Exception
    {
        logger.info("Finding All Medication on Category {}", medCategory.name());

        return drugService.findMedicationByCategory(medCategory);
    }

    /**
     * @param sideEffects
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/drug/find_by_effect")
    public List<MedicationDrug> findMedicationByEffect(@NonNull @RequestParam(name = "effect") SideEffects sideEffects)
            throws Entity_Not_Found_Exception
    {
        logger.info("Finding All Medication with effect {} ", sideEffects.name());
        return drugService.ffindMedicationByEffect(sideEffects);
    }

    // TODO : implement the following function after the mediction has been added to the hospital module

    /**
     * Find all medication available the hospital with the specified Id
     *
     * @param id
     * @return List<MedicationDrugs>
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/drug/hospital/find_all")
    public List<MedicationDrug> findMedicationDrugOnHospital(
            @NonNull
            @RequestParam(name = "hospital_id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding all Medication available at hospital With Id " + id);
        return null;
    }
}
