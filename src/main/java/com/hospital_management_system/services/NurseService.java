package com.hospital_management_system.services;

import com.hospital_management_system.model.Nurse;
import com.hospital_management_system.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> getAllNurses() {
        return (List<Nurse>) nurseRepository.findAll();
    }

    public Nurse getNurseById(Long id) {
        return nurseRepository.findById(id).orElse(null);
    }

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Long id, Nurse updatedNurse) {
        return nurseRepository.findById(id)
                .map(existingNurse -> {
                    existingNurse.setFirstName(updatedNurse.getFirstName());
                    existingNurse.setLastName(updatedNurse.getLastName());
                    existingNurse.setAddress(updatedNurse.getAddress());
                    existingNurse.setPhone(updatedNurse.getPhone());
                    existingNurse.setRotation(updatedNurse.getRotation());
                    existingNurse.setSalary(updatedNurse.getSalary());
                    return nurseRepository.save(existingNurse);
                })
                .orElse(null);
    }

    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
