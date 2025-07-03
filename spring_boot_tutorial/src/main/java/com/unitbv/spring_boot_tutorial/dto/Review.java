package com.unitbv.spring_boot_tutorial.dto;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import com.unitbv.spring_boot_tutorial.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Review {
    private UUID id;

    private String coach_id;


    private String member_id;

    private Integer mark;

}
