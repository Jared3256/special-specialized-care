package com.shan_infosystem.special_specialized_care.entity.lab.diagnosis;

import com.shan_infosystem.special_specialized_care.entity.patient.Patient;
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
@Table(uniqueConstraints = @UniqueConstraint(name = "patientDiagnosisUnique",
        columnNames = {"patient_id", "diagnosis_date"}))
public class PatientDiagnosis
{
    @Id
    @SequenceGenerator(name = "patient_diagnosis_generator", sequenceName = "patient_diagnosis_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_diagnosis_generator")
    private long diagnosisId;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = Patient.class
    )
    @JoinColumn(name = "patient_id")
    private long patientId;
    @Column(name = "diagnosis_date")
    private Instant diagnosisDate;
    @Column
    private String Provisional_Diagnosis;
    @Column
    private String Reconsultation_Advice_Week;
    @Column
    private String Reconsultation_Advice_Date;
    @Column
    private String finalDiagnosis;
    @Column
    private Boolean ecg;

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

    public long getDiagnosisId()
    {
        return diagnosisId;
    }

    public void setDiagnosisId(long diagnosisId)
    {
        this.diagnosisId = diagnosisId;
    }

    public long getPatientId()
    {
        return patientId;
    }

    public void setPatientId(long patientId)
    {
        this.patientId = patientId;
    }

    public Instant getDiagnosisDate()
    {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Instant diagnosisDate)
    {
        this.diagnosisDate = diagnosisDate;
    }

    public String getProvisional_Diagnosis()
    {
        return Provisional_Diagnosis;
    }

    public void setProvisional_Diagnosis(String provisional_Diagnosis)
    {
        Provisional_Diagnosis = provisional_Diagnosis;
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
