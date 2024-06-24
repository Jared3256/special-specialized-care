package com.shan_infosystem.special_specialized_care.entity.mdt;

import com.shan_infosystem.special_specialized_care.entity.model.MDTModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MDTService
{
    List<MDT> findAllMdts() throws Entity_Not_Found_Exception;

    ResponseEntity<MDT> findMdtById(long id) throws Entity_Not_Found_Exception;

    List<MDT> findAllByHospital(long id) throws Entity_Not_Found_Exception;

    ResponseEntity<String> createNewMDT(MDTModel mdtModel) throws Entity_Not_Found_Exception;

    ResponseEntity<String> updateMdtDetails(long id, MDTModel mdtModel) throws Entity_Not_Found_Exception;

    ResponseEntity<String> deleteMdt(long id) throws Entity_Not_Found_Exception;
}
