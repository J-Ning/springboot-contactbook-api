package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Entity
//tells JPA this is a table
@Table(name = "person")
// maps to the table called comments in the database
@Jacksonized
// to be able to set it from JSON
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// the above 4 generates getters+setters+constructors+toString()+equals()+hashCode()+builder pattern
public class Person {

    @Id
    //primary key
    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column( nullable = false, columnDefinition = "TEXT")
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String country;

    @Column(columnDefinition = "TEXT")
    private String gender;

}
