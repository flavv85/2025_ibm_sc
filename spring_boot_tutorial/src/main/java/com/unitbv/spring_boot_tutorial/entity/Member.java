package com.unitbv.spring_boot_tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
