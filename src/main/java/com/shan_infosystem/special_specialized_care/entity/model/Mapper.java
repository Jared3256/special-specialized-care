package com.shan_infosystem.special_specialized_care.entity.model;

import com.shan_infosystem.special_specialized_care.entity.community_init.Community;
import com.shan_infosystem.special_specialized_care.entity.family_unit.Family;
import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.PatientDiagnosis;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.MedicationDrug;
import com.shan_infosystem.special_specialized_care.entity.mdt.MDT;
import com.shan_infosystem.special_specialized_care.entity.patient.Patient;

import java.time.Instant;

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

    public Family toFamily(FamilyModel family, Community community)
    {
        Family family1 = new Family();
        family1.setCommunity(community);
        family1.setHead(family.getFamilyHeadId());
        return family1;
    }

    public Patient toPatient(PatientModel patient, Family family)
    {
        Patient patient1 = new Patient();
        patient1.setFamilyUnit(family);
        patient1.setGender(patient.getGender());
        patient1.setYOB(patient.getYOB());
        patient1.setName(patient.getName());
        return patient1;
    }

    public PatientDiagnosis toPatientDiagnosis(Patient patient, PatientDiagModel patientDiagnosis)
    {
        PatientDiagnosis patientDiagnosis1 = new PatientDiagnosis();
        patientDiagnosis1.setPatientId(patient);
        patientDiagnosis1.setDiagnosisDate(Instant.now());
        patientDiagnosis1.setProvisionalDiagnosis(patientDiagnosis.getProvisional_Diagnosis());
        patientDiagnosis1.setPrimaryDiagnosis(patientDiagnosis.getPrimary_diagnosis());
        patientDiagnosis1.setReconsultationAdviceWeek(patientDiagnosis.getReconsultation_Advice_Week());
        patientDiagnosis1.setReconsultationAdviceDate(patientDiagnosis.getReconsultation_Advice_Date());
        patientDiagnosis1.setFinalDiagnosis(patientDiagnosis.getFinalDiagnosis());
        patientDiagnosis1.setEcg(patientDiagnosis.getEcg());
        return patientDiagnosis1;
    }

    public MedicationDrug toMedication(MedicationDrugModel medicationDrugModel)
    {
        MedicationDrug medicationDrug = new MedicationDrug();
        medicationDrug.setName(medicationDrugModel.getName());
        medicationDrug.setManufacturer(medicationDrugModel.getManufacturer());
        medicationDrug.setSupplier(medicationDrugModel.getSupplier());
        medicationDrug.setQuantity(medicationDrugModel.getQuantity());
        medicationDrug.setSideEffects(medicationDrugModel.getSideEffects());
        return medicationDrug;
    }
}
