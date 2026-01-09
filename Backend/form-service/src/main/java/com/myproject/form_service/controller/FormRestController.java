package com.myproject.form_service.controller;

import com.myproject.form_service.model.Traveller;
import java.util.List;
import com.myproject.form_service.service.FormService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form") 
public class FormRestController {

    @Autowired
    FormService formService;

    @PostMapping
    public Traveller registerNewTraveller(@Valid @RequestBody Traveller traveller){
        return formService.registerNewTraveller(traveller);

    }

    @PutMapping("/{id}")
    public Traveller editRegisteredTraveller(@PathVariable String id,@Valid @RequestBody Traveller traveller){
        return formService.editRegisteredTraveller(id, traveller);

    }

    @GetMapping
    public List<Traveller> getAllRegisteredTraveler(){
        return formService.getAllRegisteredTraveler();

    }

    @DeleteMapping("/{id}")
    public void deleteTravellerById(@PathVariable String id){
        formService.deleteTravellerById(id);
    }



}
