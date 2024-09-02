package com.hospital_management_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;
    private String firstname;
    private String lastname;
    private String address;
    private String bedNumber;
    private String phone;
    private String email;
    private String gender;
    private String dob;
    private String diagnosis;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "department_id", referencedColumnName = "departmentId"),
            @JoinColumn(name = "ward_number", referencedColumnName = "wardNumber")
    })
    private Ward ward;
}
