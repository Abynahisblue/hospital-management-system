package com.hospital_management_system.services;

import com.hospital_management_system.model.Patient;
import com.hospital_management_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void manageNurseTransaction(Patient patient) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    // Perform operations within the transaction
                    patientRepository.save(patient);
                } catch (Exception e) {
                    // Rollback the transaction in case of an error
                    status.setRollbackOnly();
                    throw e;
                }
            }
        });
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByLastName(String lastName) {
        return patientRepository.findByLastname(lastName);
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

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
