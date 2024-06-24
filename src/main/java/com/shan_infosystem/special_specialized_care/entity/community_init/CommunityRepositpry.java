package com.shan_infosystem.special_specialized_care.entity.community_init;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityRepositpry extends JpaRepository<Community, Long>
{

    Optional<Community> findByNameAndRegistraId(String name, long registraId);
}
