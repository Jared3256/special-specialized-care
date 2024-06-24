package com.shan_infosystem.special_specialized_care.entity.lab.drug;

import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.entity.model.MedicationDrugModel;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService
{
    private Mapper mapper;

    @Autowired
    private DrugRepository drugRepository;

    /**
     * @return
     */
    @Override
    public List<MedicationDrug> findAllMedicationDrugs() throws Entity_Not_Found_Exception
    {
        List<MedicationDrug> medicationDrugs = drugRepository.findAll();

        if (medicationDrugs.isEmpty())
            throw new Entity_Not_Found_Exception("No Medication is available");

        return medicationDrugs;
    }

    /**
     * @param drugId
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public MedicationDrug findMedicationById(long drugId) throws Entity_Not_Found_Exception
    {
        Optional<MedicationDrug> medicationDrug = drugRepository.findById(drugId);

        if (medicationDrug.isEmpty())
            throw new Entity_Not_Found_Exception("No Medication is found for Id " + drugId);

        return medicationDrug.get();
    }

    /**
     * @param medCategory
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public List<MedicationDrug> findMedicationByCategory(Med_Category medCategory) throws Entity_Not_Found_Exception
    {
        List<MedicationDrug> medicationDrugs = findAllMedicationDrugs();

        List<MedicationDrug> subMedicationDrugs = medicationDrugs
                .stream()
                .filter(med -> med.getMedCategory() == medCategory)
                .toList();

        if (subMedicationDrugs.isEmpty())
            throw new Entity_Not_Found_Exception("No Medication Found on Category " + medCategory.name());
        return subMedicationDrugs;
    }

    /**
     * @param sideEffects
     * @return
     * @throws Entity_Not_Found_Exception
     */
    @Override
    public List<MedicationDrug> ffindMedicationByEffect(SideEffects sideEffects) throws Entity_Not_Found_Exception
    {
        List<MedicationDrug> medicationDrugs = findAllMedicationDrugs();

        List<MedicationDrug> subMedicationDrugs = medicationDrugs
                .stream()
                .filter(
                        med -> med
                                .getSideEffects()
                                .stream()
                                .filter(
                                        effects -> effects
                                                .name() == sideEffects.name())
                                .isParallel())
                .toList();

        if (subMedicationDrugs.isEmpty())
            throw new Entity_Not_Found_Exception("No medication Found with the related side effect");

        return subMedicationDrugs;
    }

    /**
     * @param medicationDrugModel
     * @return
     * @throws Entity_Found_Exception
     */
    @Override
    public ResponseEntity<String> addNewDrug(MedicationDrugModel medicationDrugModel) throws Entity_Found_Exception
    {
        mapper = new Mapper();

        Optional<MedicationDrug> medicationDrug = drugRepository.findByNameAndManufacturerAndMedCategory(
                medicationDrugModel.getName(),
                medicationDrugModel.getManufacturer(),
                medicationDrugModel.getMedCategory()
        );

        if (medicationDrug.isPresent())
            throw new Entity_Found_Exception("The Specified Medication is already available. Kindly update with specified details");

        drugRepository.save(mapper.toMedication(medicationDrugModel));

        return ResponseEntity.ok("Medication created and added successfully");
    }
}
