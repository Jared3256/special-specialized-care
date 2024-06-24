package com.shan_infosystem.special_specialized_care.controller.hospital;

import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalService;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sphcs/hospital/d")
public class HospitalDELETEController
{
    private static final Logger logger = LoggerFactory.getLogger(HospitalDELETEController.class);

    @Autowired
    private HospitalService hospitalService;

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteHospital(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.warn("Deleting Hospital for ID {}", id);
        return hospitalService.deleteHospital(id);
    }
}
