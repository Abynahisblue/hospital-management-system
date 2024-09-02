package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByCode(String departmentCode);

    // Find departments by building
    List<Department> findByBuilding(String building);
}
