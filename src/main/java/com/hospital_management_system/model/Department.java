package com.hospital_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "departments")
@Getter
@Setter
public class Department {

    @Id
    private String departmentId; // Change from Long to String for MongoDB

    private String code;
    private String name;
    private String building;

    @DBRef
    private Doctor director;

    @DBRef
    private List<Ward> wards;

    @DBRef
    private List<Nurse> nurses; 

}
