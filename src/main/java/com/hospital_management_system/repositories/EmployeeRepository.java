package com.hospital_management_system.repositories;

import com.hospital_management_system.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, Long> {
}
