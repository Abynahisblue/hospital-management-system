package com.hospital_management_system.services;

import com.hospital_management_system.model.Department;
import com.hospital_management_system.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }


    @Cacheable(value = "departments", key = "#id")
    public Department getDepartmentById(Long id) {
        System.out.println("Fetching departments from database...");
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "department", key = "#id"),
                    @CacheEvict(value = "building", key = "#department.building")
            },
            put = @CachePut(value = "department", key = "#id")
    )
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOpt = departmentRepository.findById(id);
        if (existingDepartmentOpt.isPresent()) {
            Department existingDepartment = existingDepartmentOpt.get();
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setBuilding(updatedDepartment.getBuilding());
            existingDepartment.setDirector(updatedDepartment.getDirector());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        Optional<Department> existingDepartmentOpt = departmentRepository.findById(id);
        if (existingDepartmentOpt.isPresent()) {
            departmentRepository.delete(existingDepartmentOpt.get());
        } else {
            throw new EntityNotFoundException("Department with id " + id + " not found");
        }
    }
}
