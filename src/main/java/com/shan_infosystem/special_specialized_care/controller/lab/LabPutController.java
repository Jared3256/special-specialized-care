package com.shan_infosystem.special_specialized_care.controller.lab;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.DiagnosisService;
import com.shan_infosystem.special_specialized_care.entity.model.PatientDiagModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Expectation_Failed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sphcs/lab/u")
@RestController
public class LabPutController
{
    private static final Logger logger = LoggerFactory.getLogger(LabPutController.class);

    @Autowired
    private DiagnosisService diagnosisService;

    /**
     * @param diagnosisId
     * @param patientDiagModel
     * @return
     * @throws Expectation_Failed
     * @throws Entity_Not_Found_Exception
     */
    @PutMapping("/diagnosis/update")
    public ResponseEntity<String> updateDiagnosis(
            @RequestParam(name = "id") long diagnosisId,
            @RequestBody PatientDiagModel patientDiagModel
    ) throws Expectation_Failed, Entity_Not_Found_Exception
    {
        logger.info("Updating diagnosis for Id " + diagnosisId);

        return diagnosisService.updateDiagnosis(diagnosisId, patientDiagModel);
    }
}
