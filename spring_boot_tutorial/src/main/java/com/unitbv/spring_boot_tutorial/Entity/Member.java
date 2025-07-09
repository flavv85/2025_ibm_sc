package com.unitbv.spring_boot_tutorial.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String email;
    @ManyToMany
    private List<FitnessClass> fitnessClasses;

}
