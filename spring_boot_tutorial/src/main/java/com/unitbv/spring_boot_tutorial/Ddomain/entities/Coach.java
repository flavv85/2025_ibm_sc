package com.unitbv.spring_boot_tutorial.Ddomain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coaches")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coach {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();
}
