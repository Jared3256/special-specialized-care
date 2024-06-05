package com.shan_infosystem.special_specialized_care.entity.model;

import com.shan_infosystem.special_specialized_care.entity.community_init.Community;
import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.mdt.MDT;

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

    public Community toCommunity(CommunityModel communityModel)
    {
        Community community = new Community();
        community.setPopulation(communityModel.getPopulation());
        community.setName(communityModel.getName());
        community.setRegistraId(communityModel.getRegistraId());
        community.setSubCounty(communityModel.getSubCounty());
        return community;
    }

    public MDT toMDT(MDTModel mdtModel)
    {
        MDT mdt = new MDT();
        mdt.setName(mdtModel.getName());
        mdt.setProffession(mdtModel.getProffession());
        return mdt;
    }
}
