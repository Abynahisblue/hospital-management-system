package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Department;
import com.hospital_management_system.model.Nurse;
import com.hospital_management_system.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WardRepository extends CrudRepository<Ward, Long> {
    List<Ward> findByDepartment(Department department);

    // Find wards by supervisor (nurse)
    List<Ward> findBySupervisor(Nurse supervisor);
}

