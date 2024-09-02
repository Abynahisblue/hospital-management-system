package com.hospital_management_system.services;

import com.hospital_management_system.model.Patient;
import com.hospital_management_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatientOpt = patientRepository.findById(id);

        if (existingPatientOpt.isPresent()) {
            Patient existingPatient = existingPatientOpt.get();
            existingPatient.setFirstname(updatedPatient.getFirstname());
            existingPatient.setLastname(updatedPatient.getLastname());
            existingPatient.setAddress(updatedPatient.getAddress());
            existingPatient.setPhone(updatedPatient.getPhone());
            existingPatient.setBedNumber(updatedPatient.getBedNumber());
            existingPatient.setDiagnosis(updatedPatient.getDiagnosis());
            existingPatient.setWard(updatedPatient.getWard());
            existingPatient.setDoctor(updatedPatient.getDoctor());
            return patientRepository.save(existingPatient);
        }

        return null;
    }
}
