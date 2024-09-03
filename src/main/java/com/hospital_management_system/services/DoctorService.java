package com.hospital_management_system.services;

import com.hospital_management_system.model.Doctor;
import com.hospital_management_system.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Creates a new doctor.
     *
     * @param doctor the doctor to create
     * @return the created doctor
     */
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Retrieves all doctors.
     *
     * @return list of doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Retrieves a doctor by its ID.
     *
     * @param id the doctor ID
     * @return the doctor if found, otherwise null
     */
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing doctor.
     *
     * @param id the doctor ID
     * @param updatedDoctor the updated doctor details
     * @return the updated doctor, or null if not found
     */
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(id);
        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();
            existingDoctor.setFirstName(updatedDoctor.getFirstName());
            existingDoctor.setLastName(updatedDoctor.getLastName());
            existingDoctor.setAddress(updatedDoctor.getAddress());
            existingDoctor.setPhone(updatedDoctor.getPhone());
            existingDoctor.setSpeciality(updatedDoctor.getSpeciality());
            return doctorRepository.save(existingDoctor);
        }
        return null;
    }

    /**
     * Deletes a doctor by ID.
     *
     * @param id the doctor ID
     */
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
