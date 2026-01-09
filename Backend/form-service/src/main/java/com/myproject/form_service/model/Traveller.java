package com.myproject.form_service.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.time.LocalDateTime;

@Data
@Document(collection = "Traveller")
public class Traveller {

    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value= 12, message = "Age must be greater than 12")
    private Integer age;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$")
    private String phoneNumber;

    @Email(message = "Invalid email address")
    private String email;

    @CreatedDate
    private LocalDateTime registrationTime;
}
