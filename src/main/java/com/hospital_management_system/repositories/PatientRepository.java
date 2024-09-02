package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Doctor;
import com.hospital_management_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Long> {
    // Find all patients by last name
    List<Patient> findByLastname(String lastName);

    // Find all patients treated by a specific doctor
    List<Patient> findByDoctor(Doctor doctor);

    // Find patients by diagnosis
    List<Patient> findByDiagnosis(String diagnosis);
}
