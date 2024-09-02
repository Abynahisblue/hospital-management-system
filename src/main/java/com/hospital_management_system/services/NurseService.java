package com.hospital_management_system.services;

import com.hospital_management_system.model.Nurse;
import com.hospital_management_system.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    private PlatformTransactionManager transactionManager;

    private void manageNurseTransaction(Nurse nurse) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // Start the transaction
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            // Perform operations within the transaction
            nurseRepository.save(nurse);

            // Commit the transaction
            transactionManager.commit(status);
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            transactionManager.rollback(status);
            throw e;
        }
    }


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
