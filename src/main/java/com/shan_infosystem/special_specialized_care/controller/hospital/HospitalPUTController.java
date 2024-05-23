package com.shan_infosystem.special_specialized_care.controller.hospital;

import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hospital/u")
public class HospitalPUTController
{
    private static final Logger logger = LoggerFactory.getLogger(HospitalPUTController.class);

    @Autowired
    private HospitalService hospitalService;

}
