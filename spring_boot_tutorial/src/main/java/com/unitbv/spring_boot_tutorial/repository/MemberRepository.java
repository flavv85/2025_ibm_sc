package com.unitbv.spring_boot_tutorial.repository;

import com.unitbv.spring_boot_tutorial.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    List<Member> findAllByFitnessClasses_Id(String fitnessClassId);
}
