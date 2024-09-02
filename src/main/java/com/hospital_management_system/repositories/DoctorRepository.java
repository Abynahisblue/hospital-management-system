package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findBySpeciality(String speciality);
}
