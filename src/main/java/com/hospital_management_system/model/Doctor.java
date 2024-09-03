package com.hospital_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;


@Setter
@Getter
@Document(collection = "doctors")
public class Doctor extends Employee{
    private String speciality;

    @DBRef
    private List<Patient> patients;


}
