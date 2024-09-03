package com.hospital_management_system.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class WardId implements Serializable {

    @DBRef
    private Department departmentId;
    private int wardNumber; // Use int for ward number, which remains part of the composite key

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + wardNumber;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WardId wardId = (WardId) o;

        if (wardNumber != wardId.wardNumber) return false;
        return Objects.equals(departmentId, wardId.departmentId);
    }
}
