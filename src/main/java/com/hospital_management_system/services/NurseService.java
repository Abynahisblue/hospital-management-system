package com.hospital_management_system.services;

import com.hospital_management_system.model.Nurse;
import com.hospital_management_system.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    /**
     * Retrieves all nurses.
     *
     * @return list of nurses
     */
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    /**
     * Retrieves a nurse by its ID.
     *
     * @param id the nurse ID
     * @return the nurse if found, otherwise null
     */
    public Nurse getNurseById(Long id) {
        return nurseRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new nurse.
     *
     * @param nurse the nurse to create
     * @return the created nurse
     */
    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    /**
     * Updates an existing nurse.
     *
     * @param id the nurse ID
     * @param updatedNurse the updated nurse details
     * @return the updated nurse, or null if not found
     */
    public Nurse updateNurse(Long id, Nurse updatedNurse) {
        Optional<Nurse> existingNurseOpt = nurseRepository.findById(id);
        if (existingNurseOpt.isPresent()) {
            Nurse existingNurse = existingNurseOpt.get();
            existingNurse.setFirstName(updatedNurse.getFirstName());
            existingNurse.setLastName(updatedNurse.getLastName());
            existingNurse.setAddress(updatedNurse.getAddress());
            existingNurse.setPhone(updatedNurse.getPhone());
            existingNurse.setRotation(updatedNurse.getRotation());
            existingNurse.setSalary(updatedNurse.getSalary());
            return nurseRepository.save(existingNurse);
        }
        return null;
    }

    /**
     * Deletes a nurse by ID.
     *
     * @param id the nurse ID
     */
    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
