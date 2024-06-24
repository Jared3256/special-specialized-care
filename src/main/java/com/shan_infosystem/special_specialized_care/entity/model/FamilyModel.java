package com.shan_infosystem.special_specialized_care.entity.model;

public class FamilyModel
{
    private Long community;

    private Long familyHeadId;

    public Long getCommunity()
    {
        return community;
    }

    public void setCommunity(Long community)
    {
        this.community = community;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FamilyModel{");
        sb.append("community=").append(community);
        sb.append('}');
        return sb.toString();
    }

    public Long getFamilyHeadId()
    {
        return familyHeadId;
    }

    public void setFamilyHeadId(Long familyHeadId)
    {
        this.familyHeadId = familyHeadId;
    }
}
