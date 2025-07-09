package com.unitbv.spring_boot_tutorial.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class ReviewDTO {
    private String id;

    private String coach_id;


    private String member_id;

    private int mark;

}
