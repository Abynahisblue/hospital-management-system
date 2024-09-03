package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, Long> {
    Department findByCode(String departmentCode);

    // Find departments by building
    List<Department> findByBuilding(String building);
}
