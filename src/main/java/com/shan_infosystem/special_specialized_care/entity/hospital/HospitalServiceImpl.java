package com.shan_infosystem.special_specialized_care.entity.hospital;

import com.shan_infosystem.special_specialized_care.entity.model.HospitalModel;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService
{
    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * @return
     */
    @Override
    public List<Hospital> findAllHospitals() throws Entity_Not_Found_Exception
    {
        List<Hospital> hospitalList = hospitalRepository.findAll();

        if(hospitalList.isEmpty())
        {
            throw new Entity_Not_Found_Exception("No Hospital Found ");
        }

        return hospitalList;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Hospital> findHospitalById(long id) throws Entity_Not_Found_Exception
    {
        Optional<Hospital> hospital = hospitalRepository.findById(id);

        if(hospital.isEmpty())
        {
            throw new Entity_Not_Found_Exception("No Hospital Found with id [ " + id + " ]");
        }

        return ResponseEntity.ok(hospital.get());
    }

    /**
     * @param hospitalModel
     * @return
     */
    @Override
    public ResponseEntity<String> createHospital(HospitalModel hospitalModel) throws Entity_Found_Exception
    {
        Optional<Hospital> hospitalOpt =hospitalRepository.findByNameAndLocation(hospitalModel.getName(), hospitalModel.getLocation());

        if (!hospitalOpt.isEmpty())
        {
            throw new Entity_Found_Exception("Hospital is already registered");
        }
        Mapper mapper = new Mapper();
        Hospital hospital = mapper.toHospital(hospitalModel);
        hospitalRepository.save(hospital);
        return ResponseEntity.ok("Hospital Created Successfuly");

    }

    /**
     * @param id
     * @param hospitalModel
     * @return
     */
    @Override
    public ResponseEntity<String> updateHospital(long id, HospitalModel hospitalModel) throws Entity_Not_Found_Exception
    {
        int count =0;
       Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

       if(optionalHospital.isEmpty())
       {
           throw new Entity_Not_Found_Exception("[ Hospital with the provided Id is not found ]");
       }

       if(!optionalHospital.get().getCode().equals(hospitalModel.getCode()) && !hospitalModel.getCode().isBlank())
       {
           optionalHospital.get().setCode(hospitalModel.getCode());
           count++;
       }

       if(optionalHospital.get().getBedCapacity() != hospitalModel.getBedCapacity() && hospitalModel.getBedCapacity() >0)
       {
           optionalHospital.get().setBedCapacity(hospitalModel.getBedCapacity());
           count++;
       }

       if(!optionalHospital.get().getName().equals(hospitalModel.getName()) && !hospitalModel.getName().isBlank())
       {
           optionalHospital.get().setName(hospitalModel.getName());
           count++;
       }

       if(count > 1)
       {
           return ResponseEntity.ok("Hospital Updated Successfully");
       }
       return ResponseEntity.ok("Hospital Data still up-to-date");


    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deleteHospital(long id) throws Entity_Not_Found_Exception
    {
       Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        if(optionalHospital.isEmpty())
        {
            throw new Entity_Not_Found_Exception("[ Hospital with the provided Id is not found ]");
        }

        hospitalRepository.delete(optionalHospital.get());

        return ResponseEntity.ok("Hospital Deleted Successfully");
    }
}
