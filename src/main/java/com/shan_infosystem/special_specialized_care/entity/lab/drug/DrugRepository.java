package com.shan_infosystem.special_specialized_care.entity.lab.drug;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrugRepository extends JpaRepository<MedicationDrug, Long>
{
    Optional<MedicationDrug> findByNameAndManufacturerAndMedCategory(String name, String manufacturer, Med_Category medCategory);
}
