package com.shan_infosystem.special_specialized_care.entity.family_unit;

import com.shan_infosystem.special_specialized_care.entity.community_init.Community;
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
import jakarta.persistence.UniqueConstraint;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "FamilyUnitUnique",
                columnNames = {"id", "community"}))
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Family
{
    @Id
    @SequenceGenerator(name = "fu_sequence", sequenceName = "fu_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fu_sequence")
    private Long id;
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            targetEntity = Community.class
    )

    @JoinColumn(name = "community")
    private long community;


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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public long getCommunity()
    {
        return community;
    }

    public void setCommunity(long community)
    {
        this.community = community;
    }
}
