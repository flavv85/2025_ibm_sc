package com.unitbv.spring_boot_tutorial.repository;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, String> {
    List<Coach>findByNameContainingIgnoreCase(String name);
    @Query("SELECT r.coach FROM Review r GROUP BY r.coach HAVING AVG(r.mark) > 8")
    List<Coach> findCoachesWithAvgMarkAbove8();
    @Query("SELECT r.coach FROM Review r GROUP BY r.coach HAVING AVG(r.mark) >= :minMark")
    List<Coach> findCoachesWithAvgMarkAbove(@Param("minMark") double minMark);

}
