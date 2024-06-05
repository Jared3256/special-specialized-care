package com.shan_infosystem.special_specialized_care.entity.lab.drug;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "patientMedicationUnique",
        columnNames = {"supplier", "manufacturer", "name"}))
public class MedicationDrug
{
    @Id
    @SequenceGenerator(name = "medication_generator", sequenceName = "medication_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_generator")
    private long medicationId;

    @Column
    private String manufacturer;

    @Column
    private String supplier;

    @Column
    private String name;

    @Column
    private Med_Category medCategory;

    @Column
    private List<SideEffects> sideEffects;

    /**
     * Audit Metrics
     */

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Date lastModified;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    public long getMedicationId()
    {
        return medicationId;
    }

    public void setMedicationId(long medicationId)
    {
        this.medicationId = medicationId;
    }

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

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getLastModified()
    {
        return lastModified;
    }

    public void setLastModified(Date lastModified)
    {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
    }
}
