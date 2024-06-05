package com.shan_infosystem.special_specialized_care.controller.lab;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.DiagnosisService;
import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.PatientDiagnosis;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private DiagnosisService diagnosisService;

    /**
     * @param patientDiagnosis
     * @return
     * @throws Entity_Not_Found_Exception
     * @throws Entity_Found_Exception
     */
    @PostMapping("/add")
    public ResponseEntity<String> addPatientDiagnosis(@RequestBody PatientDiagnosis patientDiagnosis)
            throws Entity_Not_Found_Exception, Entity_Found_Exception
    {
        logger.info("creating new diagnosis for patient " + patientDiagnosis.getPatientId());
        return diagnosisService.addPatientDiagnosis(patientDiagnosis);
    }

}
