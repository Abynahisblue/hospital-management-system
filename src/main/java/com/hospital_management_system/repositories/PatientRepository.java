package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Doctor;
import com.hospital_management_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    // Find all patients by last name
    List<Patient> findByLastName(String lastName);

    // Find all patients treated by a specific doctor
    List<Patient> findByTreatingDoctor(Doctor doctor);

    // Find patients by diagnosis
    List<Patient> findByDiagnosis(String diagnosis);
}
