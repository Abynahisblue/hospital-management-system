package com.hospital_management_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Ward implements Serializable {
    @EmbeddedId
    private WardId wardNumber;

    private int numberOfBeds;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToMany(mappedBy = "ward")
    private List<Patient> patients;

}



