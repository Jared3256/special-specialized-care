package com.shan_infosystem.special_specialized_care.entity.model;

public class PatientModel
{
    private String name;

    private long YOB;

    private Gender gender;

    private long familyUnitCode;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getYOB()
    {
        return YOB;
    }

    public void setYOB(long YOB)
    {
        this.YOB = YOB;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public long getFamilyUnitCode()
    {
        return familyUnitCode;
    }

    public void setFamilyUnitCode(long familyUnitCode)
    {
        this.familyUnitCode = familyUnitCode;
    }
}
