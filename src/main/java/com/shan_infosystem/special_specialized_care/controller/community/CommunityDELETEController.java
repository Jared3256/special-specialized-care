package com.shan_infosystem.special_specialized_care.controller.community;

import com.shan_infosystem.special_specialized_care.entity.community_init.CommunityService;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sphcs/community/d")
public class CommunityDELETEController
{
    private static final Logger logger = LoggerFactory.getLogger(CommunityDELETEController.class);

    @Autowired
    private CommunityService communityService;

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteCommunityUnit(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.warn("Deleting community with id {}", id);
        return communityService.deleteCommunityUnit(id);
    }
}
