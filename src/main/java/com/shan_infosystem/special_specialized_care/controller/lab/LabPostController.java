package com.shan_infosystem.special_specialized_care.controller.lab;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.DiagnosisService;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.DrugService;
import com.shan_infosystem.special_specialized_care.entity.model.MedicationDrugModel;
import com.shan_infosystem.special_specialized_care.entity.model.PatientDiagModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sphcs/lab/o")
public class LabPostController
{
    private static final Logger logger = LoggerFactory.getLogger(LabGetController.class);
    @Autowired
    private DrugService drugService;
    @Autowired
    private DiagnosisService diagnosisService;

    /**
     * @param patientDiagnosis
     * @return
     * @throws Entity_Not_Found_Exception
     * @throws Entity_Found_Exception
     */
    @PostMapping("/add")
    public ResponseEntity<String> addPatientDiagnosis(@RequestBody PatientDiagModel patientDiagnosis)
            throws Entity_Not_Found_Exception, Entity_Found_Exception
    {
        logger.info("creating new diagnosis for patient " + patientDiagnosis.getPatientId());
        return diagnosisService.addPatientDiagnosis(patientDiagnosis);
    }

    /**
     * Drug related functions
     */

    /**
     * @param medicationDrugModel
     * @return
     * @throws Entity_Found_Exception
     */
    @PostMapping("/drug/add")
    public ResponseEntity<String> addNewDrug(@RequestBody @NonNull MedicationDrugModel medicationDrugModel) throws Entity_Found_Exception
    {
        logger.info("creating new drug model " + medicationDrugModel.getName());
        return drugService.addNewDrug(medicationDrugModel);

    }

    // TODO :Implement this method once the hospital entity is able to handle medication drug

    /**
     * @param medicationDrugModel
     * @return
     */
    @PostMapping("/drug/hospital")
    public ResponseEntity<String> deployDrugsToHospital(@RequestBody MedicationDrugModel medicationDrugModel)
    {
        return null;
    }
}
