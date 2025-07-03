package com.unitbv.spring_boot_tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Coach {
    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    @OneToMany(mappedBy = "coach",cascade = CascadeType.ALL)
    private List<FitnessClass> fitnessClasses;
}
