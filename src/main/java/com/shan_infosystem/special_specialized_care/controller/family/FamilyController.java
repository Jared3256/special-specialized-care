package com.shan_infosystem.special_specialized_care.controller.family;

import com.shan_infosystem.special_specialized_care.entity.family_unit.Family;
import com.shan_infosystem.special_specialized_care.entity.family_unit.FamilyService;
import com.shan_infosystem.special_specialized_care.entity.model.FamilyModel;
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

import java.util.List;

@RestController
@RequestMapping("/sphcs/family")
public class FamilyController
{
    private static final Logger logger = LoggerFactory.getLogger(FamilyController.class);
    @Autowired
    private FamilyService familyService;

    /**
     * Register New Family unit
     *
     * @param family
     * @return ResponseEntity.ok(message)
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerFamilyUnit(@RequestBody FamilyModel family) throws Entity_Not_Found_Exception
    {
        logger.info("Adding new Family unit {}", family.toString());
        return familyService.registerFamilyUnit(family);
    }

    /**
     * Deleting Fmaily unit with the provided id
     *
     * @param id
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteFamilyUnit(@RequestParam(name = "id") long id)
            throws Entity_Not_Found_Exception
    {
        logger.warn("Removing family unit with Id " + id);
        return familyService.deleteFamilyUnit(id);
    }

    /**
     * Finding Family unit with id
     *
     * @param id
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/find")
    public ResponseEntity<Family> findFamilyUnit(@RequestParam(name = "id") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding family unit with id " + id);
        return familyService.findFamilyUnit(id);
    }

    /**
     * Finding all Families in the system
     *
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @GetMapping("/find_all")
    public List<Family> findAllFamilyUnits() throws Entity_Not_Found_Exception
    {
        logger.info("Finding all Family Units");
        return familyService.findAllFamilyUnits();
    }
}
