package com.shan_infosystem.special_specialized_care.controller.community;

import com.shan_infosystem.special_specialized_care.entity.community_init.Community;
import com.shan_infosystem.special_specialized_care.entity.community_init.CommunityService;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sphcs/community/g")
public class CommunityGETController
{
    private static final Logger logger = LoggerFactory.getLogger(CommunityGETController.class);

    @Autowired
    private CommunityService communityService;

    @GetMapping("/find")
    public ResponseEntity<Community> findCommunityById(
            @RequestParam(name = "id") long id
    ) throws Entity_Not_Found_Exception
    {
        logger.info("Finding Community with Id {}", id);
        return communityService.findCommunityUnitById(id);
    }

    @GetMapping("/find_all")
    public List<Community> findAllCommunities() throws Entity_Not_Found_Exception
    {
        logger.warn("[ Finding all community units ]");
        return communityService.findAllCommunityUnits();
    }

    @GetMapping("/find_all/hospital")
    public List<Community> findAllByLinkHospital(@RequestParam(name = "hospitalId") long hspId) throws Entity_Not_Found_Exception
    {
        logger.warn("Finding all communities linked to hospital {}", hspId);
        return communityService.findAllByHospital(hspId);
    }
}
