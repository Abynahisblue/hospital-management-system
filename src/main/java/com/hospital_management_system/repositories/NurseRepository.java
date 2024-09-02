package com.hospital_management_system.repositories;


import com.hospital_management_system.model.Department;
import com.hospital_management_system.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
    List<Nurse> findByAssignedDepartment(Department department);
}
