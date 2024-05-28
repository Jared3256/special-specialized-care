package com.shan_infosystem.special_specialized_care.controller.hospital;

import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalService;
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
@RequestMapping("/sphcs/hospital/g")
public class HospitalGETController
{
    private static final Logger logger = LoggerFactory.getLogger(HospitalGETController.class);

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/find_all")
    public List<Hospital> findAllHospitals() throws Entity_Not_Found_Exception
    {
        logger.info("[ Finding all Hospitals ]");
        return hospitalService.findAllHospitals();
    }

    @GetMapping("/find")
    public ResponseEntity<Hospital> findHopsitalById(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("[ Finding Hospital for Id {}]", id);
        return hospitalService.findHospitalById(id);
    }


}
