package com.shan_infosystem.special_specialized_care.entity.lab.drug;

import com.shan_infosystem.special_specialized_care.entity.model.MedicationDrugModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DrugService
{
    List<MedicationDrug> findAllMedicationDrugs() throws Entity_Not_Found_Exception;

    MedicationDrug findMedicationById(long drugId) throws Entity_Not_Found_Exception;

    List<MedicationDrug> findMedicationByCategory(Med_Category medCategory) throws Entity_Not_Found_Exception;

    List<MedicationDrug> ffindMedicationByEffect(SideEffects sideEffects) throws Entity_Not_Found_Exception;

    ResponseEntity<String> addNewDrug(MedicationDrugModel medicationDrugModel) throws Entity_Found_Exception;
}
