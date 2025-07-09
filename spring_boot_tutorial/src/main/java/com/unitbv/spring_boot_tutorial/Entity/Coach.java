package com.unitbv.spring_boot_tutorial.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class Coach{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @OneToMany(mappedBy = "coach",cascade = CascadeType.ALL)
    private List<FitnessClass> fitnessClass;
}
