package com.myproject.form_service.service;

import com.myproject.form_service.model.Traveller;
import com.myproject.form_service.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    public Traveller registerNewTraveller(Traveller traveller){
        return formRepository.insert(traveller);

    }

    public Traveller editRegisteredTraveller(String id, Traveller traveller){

        Optional<Traveller> existingTravellerOpt = formRepository.findById(id);
        if(existingTravellerOpt.isPresent()){
            Traveller traveller1 = existingTravellerOpt.get();
            traveller1.setName(traveller.getName());
            traveller1.setAge(traveller.getAge());
            traveller1.setPhoneNumber(traveller.getPhoneNumber());
            traveller1.setEmail(traveller.getEmail());

            return formRepository.save(traveller1);
        }
        else throw new RuntimeException();

    }

    public List<Traveller> getAllRegisteredTraveler(){
        return formRepository.findAll();

    }

    public void deleteTravellerById(String id){
         formRepository.deleteById(id);
    }
    public void deleteAllTraveller(){
        formRepository.deleteAll();
    }



}
