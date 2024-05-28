package com.shan_infosystem.special_specialized_care.entity.community_init;

import com.shan_infosystem.special_specialized_care.entity.model.CommunityModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommunityService
{
    ResponseEntity<Community> findCommunityUnitById(long id) throws Entity_Not_Found_Exception;

    List<Community> findAllCommunityUnits() throws Entity_Not_Found_Exception;

    ResponseEntity<String> createNewCommunity(CommunityModel communityModel) throws Entity_Found_Exception;

    ResponseEntity<String> deleteCommunityUnit(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<String> updateCommunity(long id, CommunityModel communityModel) throws Entity_Not_Found_Exception;

    List<Community> findAllByHospital(long hspId) throws Entity_Not_Found_Exception;
}
