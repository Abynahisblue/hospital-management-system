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

    /**
     * Retrieves all departments.
     *
     * @return list of departments
     */
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();  // No need for casting
    }

    /**
     * Retrieves a department by its ID, caching the result.
     *
     * @param id the department ID
     * @return the department if found, otherwise null
     */
    @Cacheable(value = "departments", key = "#id", unless = "#result == null")
    public Department getDepartmentById(Long id) {
        System.out.println("Fetching department from database...");
        return departmentRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new department.
     *
     * @param department the department to create
     * @return the created department
     */
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Updates an existing department, updating and evicting relevant caches.
     *
     * @param id the department ID
     * @param updatedDepartment the department details to update
     * @return the updated department, or null if not found
     */
    @Caching(
            evict = {
                    @CacheEvict(value = "departments", key = "#id"),
                    @CacheEvict(value = "buildings", key = "#updatedDepartment.building")  // Assuming you have a "buildings" cache
            },
            put = @CachePut(value = "departments", key = "#id")
    )
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOpt = departmentRepository.findById(id);
        if (existingDepartmentOpt.isPresent()) {
            Department existingDepartment = existingDepartmentOpt.get();
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setBuilding(updatedDepartment.getBuilding());
            existingDepartment.setDirector(updatedDepartment.getDirector());
            return departmentRepository.save(existingDepartment);
        } else {
            throw new EntityNotFoundException("Department with id " + id + " not found");
        }
    }

    /**
     * Deletes a department by ID.
     *
     * @param id the department ID
     */
    @CacheEvict(value = "departments", key = "#id")
    public void deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Department with id " + id + " not found");
        }
    }
}
