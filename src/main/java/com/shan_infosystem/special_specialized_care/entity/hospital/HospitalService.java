package com.shan_infosystem.special_specialized_care.entity.hospital;

import com.shan_infosystem.special_specialized_care.entity.model.HospitalModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HospitalService
{
    List<Hospital> findAllHospitals() throws Entity_Not_Found_Exception;

    ResponseEntity<Hospital> findHospitalById(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<String> createHospital(HospitalModel hospitalModel) throws Entity_Found_Exception;
}
