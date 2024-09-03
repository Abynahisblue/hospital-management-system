package com.hospital_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("Patient") // This tells Redis to store the Patient entity under the "Patient" key prefix
@Getter
@Setter
public class Patient implements Serializable {

    @Id
    private String patientId; // Use String for the ID to support UUIDs or other string-based keys
    private String firstname;
    private String lastname;
    private String address;
    private String bedNumber;
    private String phone;
    private String email;
    private String gender;
    private String dob;
    private String diagnosis;

    // Indexed fields are used for secondary indexing in Redis
    @Indexed
    private String doctorId; // Store the ID of the associated Doctor instead of using @ManyToOne

    @Indexed
    private String departmentId; // Store the ID of the associated Department

    @Indexed
    private String wardId; // Store the ID of the associated Ward
}
