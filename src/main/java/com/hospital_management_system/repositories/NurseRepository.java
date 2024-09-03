package com.hospital_management_system.repositories;


import com.hospital_management_system.model.Department;
import com.hospital_management_system.model.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NurseRepository extends MongoRepository<Nurse, Long> {
    List<Nurse> findByDepartment(Department departmentId);
}
