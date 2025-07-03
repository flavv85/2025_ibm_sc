package com.unitbv.spring_boot_tutorial.repository;

import com.unitbv.spring_boot_tutorial.entity.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessClassRepository extends JpaRepository<FitnessClass,String> {

}
