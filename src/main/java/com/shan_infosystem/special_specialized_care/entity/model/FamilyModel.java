package com.shan_infosystem.special_specialized_care.entity.model;

public class FamilyModel
{
    private int community;

    public int getCommunity()
    {
        return community;
    }

    public void setCommunity(int community)
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
}
