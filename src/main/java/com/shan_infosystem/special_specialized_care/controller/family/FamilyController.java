package com.shan_infosystem.special_specialized_care.controller.family;

import com.shan_infosystem.special_specialized_care.entity.family_unit.Family;
import com.shan_infosystem.special_specialized_care.entity.family_unit.FamilyService;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sphcs/family")
public class FamilyController
{
    private static final Logger logger = LoggerFactory.getLogger(FamilyController.class);
    @Autowired
    private FamilyService familyService;

    /**
     * Register a family unit
     */

    @PostMapping("/register")
    public ResponseEntity<String> registerFamilyUnit(@RequestBody Family family)
    {
        logger.info("Adding new Family unit", family.toString());
        return familyService.registerFamilyUnit(family);
    }

    /**
     * Delete a family unit
     */
    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteFamilyUnit(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.warn("Removing family unit with Id " + id);
        return familyService.deleteFamilyUnit(id);
    }

    /**
     * Find Family Unit
     */
    @GetMapping("/find")
    public ResponseEntity<Family> findFamilyUnit(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding family unit with id " + id);
        return familyService.findFamilyUnit(id);
    }
}
