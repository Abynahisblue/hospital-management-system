package com.hospital_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Doctor extends Employee{
    private String speciality;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}
