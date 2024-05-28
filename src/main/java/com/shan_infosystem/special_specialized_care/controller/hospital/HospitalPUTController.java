package com.shan_infosystem.special_specialized_care.controller.hospital;

import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalService;
import com.shan_infosystem.special_specialized_care.entity.model.HospitalModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sphcs/hospital/u")
public class HospitalPUTController
{
    private static final Logger logger = LoggerFactory.getLogger(HospitalPUTController.class);

    @Autowired
    private HospitalService hospitalService;

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateHospital(
            @RequestBody HospitalModel hospitalModel,
            @RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("[ Updating data for hospita Id {}]", id);
        return hospitalService.updateHospital(id, hospitalModel);
    }

}
