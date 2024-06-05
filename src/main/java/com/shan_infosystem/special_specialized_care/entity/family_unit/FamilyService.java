package com.shan_infosystem.special_specialized_care.entity.family_unit;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

public interface FamilyService
{
    ResponseEntity<String> registerFamilyUnit(Family family);

    ResponseEntity<String> deleteFamilyUnit(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<Family> findFamilyUnit(long id) throws Entity_Not_Found_Exception;
}
