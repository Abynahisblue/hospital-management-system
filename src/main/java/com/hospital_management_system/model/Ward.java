package com.hospital_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "wards")
@Getter
@Setter
public class Ward implements Serializable {

    @Id
    private String wardNumber;  // Use String for MongoDB ID representation

    private String name;
    private int capacity;

    @DBRef
    private Nurse supervisorId;

    // Reference to the department by its ID
    @DBRef
    private Department departmentId;

    @DBRef
    private List<Patient> patientIds;

}
