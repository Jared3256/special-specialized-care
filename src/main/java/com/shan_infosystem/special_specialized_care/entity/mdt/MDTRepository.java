package com.shan_infosystem.special_specialized_care.entity.mdt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MDTRepository extends JpaRepository<MDT, Long>
{
}
