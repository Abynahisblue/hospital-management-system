package com.hospital_management_system.services;

import com.hospital_management_system.model.Ward;
import com.hospital_management_system.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {

    @Autowired
    private WardRepository wardRepository;

    // Create a new ward
    public Ward createWard(Ward ward) {
        return wardRepository.save(ward);
    }

    // Retrieve a ward by ID
    public Ward getWardById(Long id) {
        return wardRepository.findById(id).orElse(null);
    }

    // Retrieve all wards
    public List<Ward> getAllWards() {
        return (List<Ward>) wardRepository.findAll();
    }

    // Update an existing ward
    public Ward updateWard(Long id, Ward updatedWard) {
        Optional<Ward> existingWardOpt = wardRepository.findById(id);
        if (existingWardOpt.isPresent()) {
            Ward existingWard = existingWardOpt.get();
            existingWard.setName(updatedWard.getName());
            existingWard.setCapacity(updatedWard.getCapacity());
            existingWard.setDepartment(updatedWard.getDepartment());
            return wardRepository.save(existingWard);
        }
        return null;
    }

    @Transactional(propagation = Propagation.NEVER)
    public void deleteWard(Long id) {
        wardRepository.deleteById(id);
    }
}

