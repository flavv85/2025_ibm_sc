package com.unitbv.spring_boot_tutorial.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table
public class FitnessClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name="coach",nullable = false)
    private Coach coach;

    @ManyToMany
    @JoinTable(
            name = "fitnessclass_members",
            joinColumns = @JoinColumn(name="class_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    private boolean isReady;
}
