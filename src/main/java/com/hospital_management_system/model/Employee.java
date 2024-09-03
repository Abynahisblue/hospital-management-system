package com.hospital_management_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class Employee {
    @Id
    private String id; // Change Long to String for MongoDB compatibility (ObjectId format)

    @Field("first_name") // Optional: You can specify field names to match MongoDB conventions
    private String firstName;

    @Field("last_name")
    private String lastName;

    private String email;
    private String phone;
    private String username;
    private String address;
}
