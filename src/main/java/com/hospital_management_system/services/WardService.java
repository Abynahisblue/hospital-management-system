package com.hospital_management_system.services;

import com.hospital_management_system.model.Ward;
import com.hospital_management_system.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    /**
     * Creates a new ward.
     *
     * @param ward the ward to create
     * @return the created ward
     */
    public Ward createWard(Ward ward) {
        return wardRepository.save(ward);
    }

    /**
     * Retrieves a ward by its ID.
     *
     * @param id the ward ID
     * @return the ward if found, otherwise null
     */
    public Ward getWardById(Long id) {
        return wardRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all wards.
     *
     * @return list of wards
     */
    public List<Ward> getAllWards() {
        return wardRepository.findAll();
    }

    /**
     * Updates an existing ward.
     *
     * @param id the ward ID
     * @param updatedWard the updated ward details
     * @return the updated ward, or null if not found
     */
    public Ward updateWard(Long id, Ward updatedWard) {
        Optional<Ward> existingWardOpt = wardRepository.findById(id);
        if (existingWardOpt.isPresent()) {
            Ward existingWard = existingWardOpt.get();
            existingWard.setName(updatedWard.getName());
            existingWard.setCapacity(updatedWard.getCapacity());
            existingWard.setDepartmentId(updatedWard.getDepartmentId());
            return wardRepository.save(existingWard);
        }
        return null;
    }

    /**
     * Deletes a ward by ID.
     *
     * @param id the ward ID
     */
    public void deleteWard(Long id) {
        wardRepository.deleteById(id);
    }
}
