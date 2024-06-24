package com.shan_infosystem.special_specialized_care.entity.model;

public class CommunityModel
{
    private long hospitalId;
    private long registraId;

    private String name;

    private String subCounty;

    private long population;

    public long getRegistraId()
    {
        return registraId;
    }

    public void setRegistraId(long registraId)
    {
        this.registraId = registraId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSubCounty()
    {
        return subCounty;
    }

    public void setSubCounty(String subCounty)
    {
        this.subCounty = subCounty;
    }

    public long getHospitalId()
    {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId)
    {
        this.hospitalId = hospitalId;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }
}
