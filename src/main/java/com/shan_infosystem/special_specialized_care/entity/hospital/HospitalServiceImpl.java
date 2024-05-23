package com.shan_infosystem.special_specialized_care.entity.hospital;

import com.shan_infosystem.special_specialized_care.entity.model.HospitalModel;
import com.shan_infosystem.special_specialized_care.entity.model.Mapper;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Found_Exception;
import com.shan_infosystem.special_specialized_care.exception.exception.Entity_Not_Found_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        /**
         * TODO : 1. Check if the hospital with the name and code given exists
         *        2. if exists then throw an error otherwise save and return response
         */

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
}
