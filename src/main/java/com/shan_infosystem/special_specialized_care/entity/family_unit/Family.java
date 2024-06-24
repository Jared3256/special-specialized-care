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
                columnNames = {"id", "head"})
)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Family
{
    @Id
    @SequenceGenerator(name = "fu_sequence", sequenceName = "fu_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fu_sequence")
    private Long id;

    private Long head;
    @OneToOne(
            targetEntity = Community.class,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Community community;


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

    public Community getCommunity()
    {
        return community;
    }

    public void setCommunity(Community community)
    {
        this.community = community;
    }

    public Long getHead()
    {
        return head;
    }

    public void setHead(Long head)
    {
        this.head = head;
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
