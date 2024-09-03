package com.hospital_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Setter
@Getter
public class Doctor extends Employee{

    private String speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

}
