package com.shan_infosystem.special_specialized_care.entity.family_unit;

import com.shan_infosystem.special_specialized_care.entity.model.FamilyModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FamilyService
{
    ResponseEntity<String> registerFamilyUnit(FamilyModel family) throws Entity_Not_Found_Exception;

    ResponseEntity<String> deleteFamilyUnit(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<Family> findFamilyUnit(long id) throws Entity_Not_Found_Exception;

    List<Family> findAllFamilyUnits() throws Entity_Not_Found_Exception;
}
