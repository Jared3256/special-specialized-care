package com.shan_infosystem.special_specialized_care.entity.family_unit;

import com.shan_infosystem.special_specialized_care.entity.community_init.Community;
import com.shan_infosystem.special_specialized_care.entity.community_init.CommunityRepositpry;
import com.shan_infosystem.special_specialized_care.entity.model.FamilyModel;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService
{
    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private CommunityRepositpry communityRepositpry;

    private Mapper mapper;

    /**
     * @param family
     * @return
     */
    @Override
    public ResponseEntity<String> registerFamilyUnit(FamilyModel family) throws Entity_Not_Found_Exception
    {
        Optional<Community> optionalCommunity = communityRepositpry.findById(family.getCommunity());

        if (optionalCommunity.isEmpty())
            throw new Entity_Not_Found_Exception("Canot register family to non-existing community. Check your ID");

        
        mapper = new Mapper();
        familyRepository.save(mapper.toFamily(family, optionalCommunity.get()));
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

    /**
     * @return
     */
    @Override
    public List<Family> findAllFamilyUnits() throws Entity_Not_Found_Exception
    {
        List<Family> families = familyRepository.findAll();

        if (families.isEmpty())
            throw new Entity_Not_Found_Exception("No Family Unit found");

        return families;
    }
}
