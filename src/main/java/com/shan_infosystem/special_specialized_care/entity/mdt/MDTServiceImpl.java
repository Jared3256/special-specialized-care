package com.shan_infosystem.special_specialized_care.entity.mdt;

import com.shan_infosystem.special_specialized_care.entity.hospital.Hospital;
import com.shan_infosystem.special_specialized_care.entity.hospital.HospitalRepository;
import com.shan_infosystem.special_specialized_care.entity.model.MDTModel;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MDTServiceImpl implements MDTService
{
    @Autowired
    private MDTRepository mdtRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * @return
     */
    @Override
    public List<MDT> findAllMdts() throws Entity_Not_Found_Exception
    {
        List<MDT> mdts = mdtRepository.findAll();

        if (mdts.isEmpty())
            throw new Entity_Not_Found_Exception("No MDT found");

        return mdts;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<MDT> findMdtById(long id) throws Entity_Not_Found_Exception
    {
        Optional<MDT> optionalMDT = mdtRepository.findById(id);

        if (optionalMDT.isEmpty())
            throw new Entity_Not_Found_Exception("MDT with Id " + id + " is not found");

        return ResponseEntity.ok(optionalMDT.get());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<MDT> findAllByHospital(long id) throws Entity_Not_Found_Exception
    {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        if (optionalHospital.isEmpty())
            throw new Entity_Not_Found_Exception("Hospital with tha Id is not found");

        List<MDT> mdts = mdtRepository.findAll();

        if (mdts.isEmpty())
            throw new Entity_Not_Found_Exception("No MDT found in our database");

        List<MDT> newMDT = mdts
                .stream()
                .filter(mdt -> mdt.getHospital().getId() == id
                )
                .toList();

        if (newMDT.isEmpty())
            throw new Entity_Not_Found_Exception("No MDT is linked to hospital of Id " + id);

        return newMDT;
    }

    /**
     * @param mdtModel
     * @return
     */
    @Override
    public ResponseEntity<String> createNewMDT(MDTModel mdtModel) throws Entity_Not_Found_Exception
    {
        Mapper mapper = new Mapper();
        MDT mdt = mapper.toMDT(mdtModel);

        Optional<Hospital> optionalHospital = hospitalRepository.findById(mdtModel.getHospitalId());

        if (optionalHospital.isEmpty())
            throw new Entity_Not_Found_Exception("Cannot register MDT to non-existing Hospital");

        mdt.setHospital(optionalHospital.get());

        mdtRepository.save(mdt);
        return ResponseEntity.ok("MDT registered successfully");
    }

    /**
     * @param id
     * @param mdtModel
     * @return
     */
    @Override
    public ResponseEntity<String> updateMdtDetails(long id, MDTModel mdtModel) throws Entity_Not_Found_Exception
    {
        Optional<MDT> optionalMDT = mdtRepository.findById(id);

        if (optionalMDT.isEmpty())
            throw new Entity_Not_Found_Exception("Unable to find MDT with id " + id);

        if (!mdtModel.getName().isEmpty() && mdtModel.getName().equals(optionalMDT.get().getName()))
        {
            optionalMDT.get().setName(mdtModel.getName());
            return ResponseEntity.ok("MDT name updated successfully");
        }
        return ResponseEntity.ok("MDT is up to date");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deleteMdt(long id) throws Entity_Not_Found_Exception
    {
        Optional<MDT> optionalMDT = mdtRepository.findById(id);

        if (optionalMDT.isEmpty())
            throw new Entity_Not_Found_Exception("Unable to find MDT of id " + id);

        mdtRepository.delete(optionalMDT.get());
        return ResponseEntity.ok("MDT Deleted successfully");
    }
}
