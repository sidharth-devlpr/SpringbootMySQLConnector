package com.example.MySQLSpring;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "No.")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    @Column(name = "FirstName")
    private String name;

    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "Age")
    @NotNull
    private int age;
}
