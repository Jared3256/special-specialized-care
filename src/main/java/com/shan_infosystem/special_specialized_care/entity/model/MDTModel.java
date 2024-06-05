package com.shan_infosystem.special_specialized_care.entity.model;

public class MDTModel
{
    private String name;
    private Proffession proffession;
    private long hospitalId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Proffession getProffession()
    {
        return proffession;
    }

    public void setProffession(Proffession proffession)
    {
        this.proffession = proffession;
    }

    public long getHospitalId()
    {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId)
    {
        this.hospitalId = hospitalId;
    }
}
