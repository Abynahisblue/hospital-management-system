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

    /**
     * Creates a new patient.
     *
     * @param patient the patient to create
     * @return the created patient
     */
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * Retrieves all patients.
     *
     * @return list of patients
     */
    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    /**
     * Retrieves a patient by its ID.
     *
     * @param id the patient ID
     * @return the patient if found, otherwise null
     */
    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves patients by their last name.
     *
     * @param lastName the last name to search for
     * @return list of patients with the given last name
     */
    public List<Patient> getPatientsByLastName(String lastName) {
        return patientRepository.findByLastname(lastName);
    }

    /**
     * Updates an existing patient.
     *
     * @param id the patient ID
     * @param updatedPatient the updated patient details
     * @return the updated patient, or null if not found
     */
    public Patient updatePatient(String id, Patient updatedPatient) {
        Optional<Patient> existingPatientOpt = patientRepository.findById(id);

        if (existingPatientOpt.isPresent()) {
            Patient existingPatient = existingPatientOpt.get();
            existingPatient.setFirstname(updatedPatient.getFirstname());
            existingPatient.setLastname(updatedPatient.getLastname());
            existingPatient.setAddress(updatedPatient.getAddress());
            existingPatient.setPhone(updatedPatient.getPhone());
            existingPatient.setBedNumber(updatedPatient.getBedNumber());
            existingPatient.setDiagnosis(updatedPatient.getDiagnosis());
            existingPatient.setWardId(updatedPatient.getWardId());
            existingPatient.setDoctorId(updatedPatient.getDoctorId());
            existingPatient.setDepartmentId(updatedPatient.getDepartmentId());
            return patientRepository.save(existingPatient);
        }

        return null;
    }

    /**
     * Deletes a patient by ID.
     *
     * @param id the patient ID
     */
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
