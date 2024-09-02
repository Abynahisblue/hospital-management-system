package com.hospital_management_system.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String code;
    private String name;
    private String building;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private List<Ward> wards;

    @OneToMany(mappedBy = "department")
    private List<Nurse> nurses;

}
