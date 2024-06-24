package com.shan_infosystem.special_specialized_care.entity.community_init;

import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalRepository;
import com.shan_infosystem.special_specialized_care.entity.model.CommunityModel;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommunityServiceImpl implements CommunityService
{
    @Autowired
    private CommunityRepositpry communityRepositpry;

    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Community> findCommunityUnitById(long id) throws Entity_Not_Found_Exception
    {
        Optional<Community> optionalCommunity = communityRepositpry.findById(id);

        if (optionalCommunity.isEmpty())
            throw new Entity_Not_Found_Exception("Community unit with Id " + id + " does not exist");

        return ResponseEntity.ok(optionalCommunity.get());
    }

    /**
     * @return
     */
    @Override
    public List<Community> findAllCommunityUnits() throws Entity_Not_Found_Exception
    {
        List<Community> communities = communityRepositpry.findAll();

        if (communities.isEmpty())
            throw new Entity_Not_Found_Exception(" Community found in the database");

        return communities;
    }

    /**
     * @param communityModel
     * @return
     */
    @Override
    public ResponseEntity<String> createNewCommunity(CommunityModel communityModel) throws Entity_Found_Exception
    {
        Mapper mapper = new Mapper();

        Optional<Community> community = communityRepositpry.findByNameAndRegistraId(communityModel.getName(), communityModel.getRegistraId());

        if (!community.isEmpty())
            throw new Entity_Found_Exception("Community With specified details is already registered");

        Community newCommunity = mapper.toCommunity(communityModel);

        Optional<Hospital> optionalHospital = hospitalRepository.findById(communityModel.getHospitalId());

        if (optionalHospital.isEmpty())
            throw new Entity_Found_Exception("[ Unable to Link your community with non-existing hospital. Check your hospital id]");

        newCommunity.setHospital(optionalHospital.get());

        communityRepositpry.save(newCommunity);

        return ResponseEntity.ok("Community registered Successfully");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deleteCommunityUnit(long id) throws Entity_Not_Found_Exception
    {
        Optional<Community> optionalCommunity = communityRepositpry.findById(id);


        if (optionalCommunity.isEmpty())
            throw new Entity_Not_Found_Exception("Community Unit with ID " + id + " is not found");

        communityRepositpry.deleteById(id);

        return ResponseEntity.ok("Community Unit Deleted Successfully");
    }

    /**
     * @param id
     * @param communityModel
     * @return
     */
    @Override
    public ResponseEntity<String> updateCommunity(long id, CommunityModel communityModel) throws Entity_Not_Found_Exception
    {
        int counter = 0;
        Optional<Community> optionalCommunity = communityRepositpry.findById(id);

        if (optionalCommunity.isEmpty())
            throw new Entity_Not_Found_Exception("Community with that Id is not found");

        Community community = optionalCommunity.get();
        if (!communityModel.getName().isBlank() && !community.getName().equals(communityModel.getName()))
        {
            counter++;
            community.setName(communityModel.getName());
        }

        if (counter == 0)
            return ResponseEntity.ok("Community " + id + " is up to date");

        return ResponseEntity.ok("Community Updates Successfully");
    }

    /**
     * @param hspId
     * @return
     */
    @Override
    public List<Community> findAllByHospital(long hspId) throws Entity_Not_Found_Exception
    {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hspId);

        if (optionalHospital.isEmpty())
            throw new Entity_Not_Found_Exception("Hospital with tha Id is not found");

        List<Community> communities = communityRepositpry.findAll();

        if (communities.isEmpty())
            throw new Entity_Not_Found_Exception("No Community found in our database");

        List<Community> newCommunity = communities
                .stream()
                .filter(community ->
                        community.getHospital().getId() == hspId
                )
                .toList();

        if (newCommunity.isEmpty())
            throw new Entity_Not_Found_Exception("No Community is linked to hospital of Id " + hspId);

        return newCommunity;
    }
}
