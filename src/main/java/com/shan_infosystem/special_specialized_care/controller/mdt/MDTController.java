package com.shan_infosystem.special_specialized_care.controller.mdt;

import com.shan_infosystem.special_specialized_care.entity.mdt.MDT;
import com.shan_infosystem.special_specialized_care.entity.mdt.MDTService;
import com.shan_infosystem.special_specialized_care.entity.model.MDTModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sphcs/mdt")
public class MDTController
{
    private static final Logger logger = LoggerFactory.getLogger(MDTController.class);

    @Autowired
    private MDTService mdtService;

    /**
     * GET Mapping methods
     */

    @GetMapping("/g/get_all")
    public List<MDT> findAllMdts() throws Entity_Not_Found_Exception
    {
        logger.warn("[ Finding all mdts ]");
        return mdtService.findAllMdts();
    }

    @GetMapping("/g/get")
    public ResponseEntity<MDT> findMDTById(
            @RequestParam(name = "id") long id
    ) throws Entity_Not_Found_Exception
    {
        logger.info("Finding MDT with Id {}", id);
        return mdtService.findMdtById(id);
    }

    @GetMapping("/g/get_all/hospital")
    public List<MDT> findAllByHospital(@RequestParam(name = "hospital") long id) throws Entity_Not_Found_Exception
    {
        logger.info("Finding all MDT from hospital of Id {}", id);
        return mdtService.findAllByHospital(id);
    }

    /**
     * POST Mapping methods
     */

    @PostMapping("/o/create")
    public ResponseEntity<String> registerMDT(
            @RequestBody MDTModel mdtModel
    ) throws Entity_Not_Found_Exception
    {
        logger.info("Creating new MDT");
        return mdtService.createNewMDT(mdtModel);
    }

    /**
     * PUT Mapping methods
     */

    @PutMapping("/u/update")
    public ResponseEntity<String> updateMdt(@RequestParam(name = "mdtId") long id,
                                            @RequestBody MDTModel mdtModel) throws Entity_Not_Found_Exception
    {
        logger.info("Updating MDT details for id {}", id);
        return mdtService.updateMdtDetails(id, mdtModel);
    }

    /**
     * DELETE Mapping methods
     */
    @DeleteMapping("/d/remove")
    public ResponseEntity<String> deleteMdt(@RequestParam(name = "mdtId") long id) throws Entity_Not_Found_Exception
    {
        logger.warn("Deleting MDT with ID {}", id);
        return mdtService.deleteMdt(id);
    }
}
