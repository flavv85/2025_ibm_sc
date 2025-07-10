package com.unitbv.spring_boot_tutorial.Ddomain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fitness_classes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessClass {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "fitness_class_members",
            joinColumns = @JoinColumn(name = "fitness_class_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members = new HashSet<>();

    @Transient
    private String isReady;

    public Boolean getIsReady() {
        return members != null && members.size() >= 3;
    }

    public void addMember(Member member) {
        if (members == null) {
            members = new HashSet<>();
        }
        members.add(member);
        if (member.getFitnessClasses() == null) {
            member.setFitnessClasses(new HashSet<>());
        }
        member.getFitnessClasses().add(this);
    }

    public void removeMember(Member member) {
        if (members != null) {
            members.remove(member);
            if (member.getFitnessClasses() != null) {
                member.getFitnessClasses().remove(this);
            }
        }
    }
}
