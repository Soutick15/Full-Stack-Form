package com.myproject.form_service.repository;

import com.myproject.form_service.model.Traveller;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface FormRepository extends MongoRepository<Traveller, String> {


}
