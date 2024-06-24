package com.shan_infosystem.special_specialized_care.controller.community;

import com.shan_infosystem.special_specialized_care.entity.community_init.CommunityService;
import com.shan_infosystem.special_specialized_care.entity.model.CommunityModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sphcs/community/o")
@CrossOrigin(origins = "http://localhost:5173")
public class CommunityPOSTController
{
    private static final Logger logger = LoggerFactory.getLogger(CommunityPOSTController.class);

    @Autowired
    private CommunityService communityService;

    @PostMapping("/create")
    public ResponseEntity<String> createNewCommunityUnit(@RequestBody CommunityModel communityModel) throws Entity_Found_Exception
    {
        logger.info("Creating new Community", communityModel);
        return communityService.createNewCommunity(communityModel);
    }
}
