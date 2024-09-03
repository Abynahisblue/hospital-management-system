package com.hospital_management_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Document(collection = "nurses") // Specifies that this class will be stored in the "nurses" collection
public class Nurse extends Employee {

    private String rotation;
    private Double salary;

    // Use DBRef to reference related documents in MongoDB
    @DBRef
    private Department department;

    @DBRef
    private Ward ward;
}
