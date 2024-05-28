package com.shan_infosystem.special_specialized_care.controller.community;

import com.shan_infosystem.special_specialized_care.entity.community_init.CommunityService;
import com.shan_infosystem.special_specialized_care.entity.model.CommunityModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sphcs/community/u")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CommunityPUTController
{
    private static final Logger logger = LoggerFactory.getLogger(CommunityPUTController.class);

    @Autowired
    private CommunityService communityService;

    @PutMapping("/update")
    public ResponseEntity<String> updateCommunity(
            @RequestBody CommunityModel communityModel,
            @RequestParam(name = "id") long id
    ) throws Entity_Not_Found_Exception
    {
        logger.info("Updating information on Community {}", id);
        return communityService.updateCommunity(id, communityModel);
    }
}
