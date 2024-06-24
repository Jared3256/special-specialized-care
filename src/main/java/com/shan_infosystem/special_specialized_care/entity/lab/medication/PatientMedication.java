package com.shan_infosystem.special_specialized_care.entity.lab.medication;

import com.shan_infosystem.special_specialized_care.entity.lab.diagnosis.PatientDiagnosis;
import com.shan_infosystem.special_specialized_care.entity.lab.drug.MedicationDrug;
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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        name = "patientMedicationUnique",
        columnNames = {"diagnosis_id", "medication_date"}))
public class PatientMedication
{
    @Id
    @SequenceGenerator(name = "patient_medication_generator", sequenceName = "patient_medication_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_medication_generator")
    private long medicationId;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = PatientDiagnosis.class
    )
    @JoinColumn(name = "diagnosis_id")
    private PatientDiagnosis diagnosisId;

    @Column(name = "medication_date")
    private Instant medicationDate;

    @Column
    private String prescription;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = MedicationDrug.class
    )
    @JoinColumn(name = "medicine_id")
    private long prescribedDrugId;

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

    public PatientDiagnosis getDiagnosisId()
    {
        return diagnosisId;
    }

    public void setDiagnosisId(PatientDiagnosis diagnosisId)
    {
        this.diagnosisId = diagnosisId;
    }

    public Instant getMedicationDate()
    {
        return medicationDate;
    }

    public void setMedicationDate(Instant medicationDate)
    {
        this.medicationDate = medicationDate;
    }

    public String getPrescription()
    {
        return prescription;
    }

    public void setPrescription(String prescription)
    {
        this.prescription = prescription;
    }

    public long getPrescribedDrugId()
    {
        return prescribedDrugId;
    }

    public void setPrescribedDrugId(long prescribedDrugId)
    {
        this.prescribedDrugId = prescribedDrugId;
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
