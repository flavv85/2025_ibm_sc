package com.unitbv.spring_boot_tutorial.entity;

import com.unitbv.spring_boot_tutorial.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Member {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToMany(mappedBy = "members")
    private Set<FitnessClass> fitnessClasses;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews;
}




