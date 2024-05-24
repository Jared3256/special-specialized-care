package com.shan_infosystem.special_specialized_care.controller.hospital;

import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalService;
import com.shan_infosystem.special_specialized_care.entity.model.HospitalModel;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hospital/o")
public class HospitalPOSTControlller
{
    private static final Logger logger = LoggerFactory.getLogger(HospitalPOSTControlller.class);

    @Autowired
    private HospitalService hospitalService;

    public ResponseEntity<String> createHospital(@RequestBody HospitalModel hospitalModel) throws Entity_Found_Exception
    {
        logger.info( "Adding Hospital ", hospitalModel);
        return hospitalService.createHospital(hospitalModel);
    }
}
