package com.shan_infosystem.special_specialized_care.entity.model;

import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;

public class Mapper
{
    public Hospital toHospital(HospitalModel hospitalModel)
    {
        Hospital hospital = new Hospital();
        hospital.setCode(hospitalModel.getCode());
        hospital.setBedCapacity(hospitalModel.getBedCapacity());
        hospital.setName(hospitalModel.getName());
        hospital.setLocation(hospitalModel.getLocation());
        return hospital;
    }
}
