package com.shan_infosystem.special_specialized_care.controller.patient;

import com.shan_infosystem.special_specialized_care.entity.patient.Patient;
import com.shan_infosystem.special_specialized_care.entity.patient.PatientService;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sphcs/patient")
public class PatientController
{
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    /**
     * Get patient with id
     */
    @GetMapping("/g/find")
    public ResponseEntity<Patient> findPatientById(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding Patient with Id " + id);
        return patientService.findPatientById(id);
    }

    /**
     * Add new Patient
     */
    @PostMapping("/o/add")
    public ResponseEntity<String> registerNewPatient(@RequestBody Patient patient) throws Entity_Found_Exception
    {
        logger.info("Adding new Patient to the service");
        return patientService.registerNewPatient(patient);
    }

    /**
     * Remove the PAtient from the service
     */
    @DeleteMapping("/d/remove")
    public ResponseEntity<String> removePatientById(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.warn("Deleting PAtient of Id " + id + " from the service");
        return patientService.deletePatientById(id);
    }

}
