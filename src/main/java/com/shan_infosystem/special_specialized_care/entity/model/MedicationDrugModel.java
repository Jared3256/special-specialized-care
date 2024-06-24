package com.shan_infosystem.special_specialized_care.entity.model;

import com.shan_infosystem.special_specialized_care.entity.lab.drug.Med_Category;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.SideEffects;

import java.util.List;

public class MedicationDrugModel
{
    private String manufacturer;
    private String supplier;
    private String name;
    private long quantity;
    private Med_Category medCategory;
    private List<SideEffects> sideEffects;

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getSupplier()
    {
        return supplier;
    }

    public void setSupplier(String supplier)
    {
        this.supplier = supplier;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Med_Category getMedCategory()
    {
        return medCategory;
    }

    public void setMedCategory(Med_Category medCategory)
    {
        this.medCategory = medCategory;
    }

    public List<SideEffects> getSideEffects()
    {
        return sideEffects;
    }

    public void setSideEffects(List<SideEffects> sideEffects)
    {
        this.sideEffects = sideEffects;
    }

    public long getQuantity()
    {
        return quantity;
    }

    public void setQuantity(long quantity)
    {
        this.quantity = quantity;
    }
}

