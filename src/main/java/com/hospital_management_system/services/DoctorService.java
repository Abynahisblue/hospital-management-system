package com.hospital_management_system.services;

import com.hospital_management_system.model.Doctor;
import com.hospital_management_system.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }


    // Retrieve a doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    // Update an existing doctor
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id)
                .map(existingDoctor -> {
                    existingDoctor.setFirstName(updatedDoctor.getFirstName());
                    existingDoctor.setLastName(updatedDoctor.getLastName());
                    existingDoctor.setAddress(updatedDoctor.getAddress());
                    existingDoctor.setPhone(updatedDoctor.getPhone());
                    existingDoctor.setSpeciality(updatedDoctor.getSpeciality());
                    return doctorRepository.save(existingDoctor);
                })
                .orElse(null);
    }

    // Delete a doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
