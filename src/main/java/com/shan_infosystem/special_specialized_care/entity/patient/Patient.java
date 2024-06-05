package com.shan_infosystem.special_specialized_care.entity.patient;

import com.shan_infosystem.special_specialized_care.entity.family_unit.Family;
import com.shan_infosystem.special_specialized_care.entity.model.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "patientUnique",
                columnNames = {
                        "id",
                        "name",
                        "family_unit"
                }))
@Entity
public class Patient
{
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;

    @Column
    private String name;

    @Column
    private long YOB;

    @Column
    private Gender gender;

    @OneToOne(
            cascade = CascadeType.ALL,
            targetEntity = Family.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "family_unit")
    private long familyUnit;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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

    public long getFamilyUnit()
    {
        return familyUnit;
    }

    public void setFamilyUnit(long familyUnit)
    {
        this.familyUnit = familyUnit;
    }
}
