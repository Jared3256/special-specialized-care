package com.shan_infosystem.special_specialized_care.entity.model;

import jakarta.persistence.Column;

public class HospitalModel
{
    private String name;
    private String code;
    private String location;
    private long bedCapacity;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public long getBedCapacity()
    {
        return bedCapacity;
    }

    public void setBedCapacity(long bedCapacity)
    {
        this.bedCapacity = bedCapacity;
    }
}
