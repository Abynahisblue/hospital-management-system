package com.hospital_management_system.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Setter
@Getter
@Embeddable
public class WardId implements Serializable {
    private Long departmentId;
    private int wardNumber;

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
