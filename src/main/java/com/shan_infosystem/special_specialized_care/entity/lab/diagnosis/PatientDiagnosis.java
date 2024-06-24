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
    private Patient patientId;
    @Column(name = "diagnosis_date")
    private Instant diagnosisDate;
    @Column
    private String provisionalDiagnosis;

    @Column
    private String primaryDiagnosis;
    @Column
    private String reconsultationAdviceWeek;
    @Column
    private String reconsultationAdviceDate;
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

    public Patient getPatientId()
    {
        return patientId;
    }

    public void setPatientId(Patient patientId)
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

    public String getProvisionalDiagnosis()
    {
        return provisionalDiagnosis;
    }

    public void setProvisionalDiagnosis(String provisionalDiagnosis)
    {
        this.provisionalDiagnosis = provisionalDiagnosis;
    }

    public String getPrimaryDiagnosis()
    {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis)
    {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getReconsultationAdviceWeek()
    {
        return reconsultationAdviceWeek;
    }

    public void setReconsultationAdviceWeek(String reconsultationAdviceWeek)
    {
        this.reconsultationAdviceWeek = reconsultationAdviceWeek;
    }

    public String getReconsultationAdviceDate()
    {
        return reconsultationAdviceDate;
    }

    public void setReconsultationAdviceDate(String reconsultationAdviceDate)
    {
        this.reconsultationAdviceDate = reconsultationAdviceDate;
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
    } //ghghgh

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
