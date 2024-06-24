package com.shan_infosystem.special_specialized_care.entity.mdt;

import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.model.Proffession;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class MDT
{
    @Id
    @SequenceGenerator(name = "mdt_sequence", sequenceName = "mdt_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mdt_sequence")
    private long id;

    @Column
    private String name;

    @Column
    private Proffession proffession;

    @OneToOne(
            targetEntity = Hospital.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(referencedColumnName = "id")
    private Hospital hospital;

    /**
     * Audit features
     */
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified", insertable = false)
    private Date lastModified;

    @LastModifiedBy
    @Column(name = "last_modified_by", insertable = false)
    private String lastModifiedBy;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public Proffession getProffession()
    {
        return proffession;
    }

    public void setProffession(Proffession proffession)
    {
        this.proffession = proffession;
    }

    public Hospital getHospital()
    {
        return hospital;
    }

    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
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
