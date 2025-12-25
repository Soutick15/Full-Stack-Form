package com.myproject.form_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Traveller")
public class Traveller {

    @Id
	private String id;
	private String name;
	private Integer age;
	private Long phoneNumber;
	private String email;
}
