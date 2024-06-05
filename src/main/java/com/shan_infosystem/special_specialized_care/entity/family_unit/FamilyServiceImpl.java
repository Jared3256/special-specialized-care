package com.shan_infosystem.special_specialized_care.entity.family_unit;

import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService
{
    @Autowired
    private FamilyRepository familyRepository;

    /**
     * @param family
     * @return
     */
    @Override
    public ResponseEntity<String> registerFamilyUnit(Family family)
    {
        familyRepository.save(family);
        return ResponseEntity.ok("Family Unit registered successffully");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deleteFamilyUnit(long id) throws Entity_Not_Found_Exception
    {
        Optional<Family> optionalFamily = familyRepository.findById(id);

        if (optionalFamily.isEmpty())
            throw new Entity_Not_Found_Exception("Cannot delete Family Unit with Id " + id);

        familyRepository.deleteById(id);
        
        return ResponseEntity.ok("Family Unit deleted successfully");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Family> findFamilyUnit(long id) throws Entity_Not_Found_Exception
    {
        Optional<Family> optionalFamily = familyRepository.findById(id);

        if (optionalFamily.isEmpty())
            throw new Entity_Not_Found_Exception("Family Unit with Id " + id + " is not found");

        return ResponseEntity.ok(optionalFamily.get());
    }
}
