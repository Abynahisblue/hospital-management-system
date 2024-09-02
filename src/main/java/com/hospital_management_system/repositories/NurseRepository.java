package com.hospital_management_system.repositories;


import com.hospital_management_system.model.Department;
import com.hospital_management_system.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NurseRepository extends CrudRepository<Nurse, Long> {
    List<Nurse> findByDepartment(Department department);
}
