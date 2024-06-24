package com.shan_infosystem.special_specialized_care.entity.model;

public class PatientDiagModel
{
    private long patientId;
    private String Provisional_Diagnosis;
    private String primary_diagnosis;
    private String Reconsultation_Advice_Week;
    private String Reconsultation_Advice_Date;
    private String finalDiagnosis;
    private Boolean ecg;

    public long getPatientId()
    {
        return patientId;
    }

    public void setPatientId(long patientId)
    {
        this.patientId = patientId;
    }

    public String getProvisional_Diagnosis()
    {
        return Provisional_Diagnosis;
    }

    public void setProvisional_Diagnosis(String provisional_Diagnosis)
    {
        Provisional_Diagnosis = provisional_Diagnosis;
    }

    public String getPrimary_diagnosis()
    {
        return primary_diagnosis;
    }

    public void setPrimary_diagnosis(String primary_diagnosis)
    {
        this.primary_diagnosis = primary_diagnosis;
    }

    public String getReconsultation_Advice_Week()
    {
        return Reconsultation_Advice_Week;
    }

    public void setReconsultation_Advice_Week(String reconsultation_Advice_Week)
    {
        Reconsultation_Advice_Week = reconsultation_Advice_Week;
    }

    public String getReconsultation_Advice_Date()
    {
        return Reconsultation_Advice_Date;
    }

    public void setReconsultation_Advice_Date(String reconsultation_Advice_Date)
    {
        Reconsultation_Advice_Date = reconsultation_Advice_Date;
    }

    public String getFinalDiagnosis()
    {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis)
    {
        this.finalDiagnosis = finalDiagnosis;
    }

    public Boolean getEcg()
    {
        return ecg;
    }

    public void setEcg(Boolean ecg)
    {
        this.ecg = ecg;
    }
}
