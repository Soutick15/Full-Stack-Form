package com.myproject.form_service;

import com.myproject.form_service.model.Traveller;
import com.myproject.form_service.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataInitializationService implements CommandLineRunner {

    private final FormRepository formRepository;

    @Override
    public void run(String... args) throws Exception {

            log.info("Initializing database with dummy data...");

            List<Traveller> travellers = Arrays.asList(
                    createTraveller("John Doe", 25, "9876543210", "john.doe@example.com"),
                    createTraveller("Jane Smith", 30, "9876543211", "jane.smith@example.com"),
                    createTraveller("Bob Johnson", 28, "9876543212", "bob.johnson@example.com"),
                    createTraveller("Alice Williams", 22, "9876543213", "alice.williams@example.com"),
                    createTraveller("Charlie Brown", 35, "9876543214", "charlie.brown@example.com")
            );

            formRepository.saveAll(travellers);
            log.info("Successfully initialized {} travellers in the database", travellers.size());

    }

    private Traveller createTraveller(String name, Integer age, String phoneNumber, String email) {
        Traveller traveller = new Traveller();
        traveller.setName(name);
        traveller.setAge(age);
        traveller.setPhoneNumber(phoneNumber);
        traveller.setEmail(email);
        traveller.setRegistrationTime(LocalDateTime.now());
        return traveller;
    }
}