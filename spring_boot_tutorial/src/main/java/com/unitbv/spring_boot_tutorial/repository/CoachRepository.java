package com.unitbv.spring_boot_tutorial.repository;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, String> {
    Optional<Coach> findByNameContainingIgnoreCase(String name);
    @Query("SELECT r.coach FROM Review r GROUP BY r.coach HAVING AVG(r.mark) > 8")
    Optional<Coach> findCoachesWithAvgMarkAbove8();
    @Query("SELECT r.coach FROM Review r GROUP BY r.coach HAVING AVG(r.mark) >= :minMark")
    Optional<Coach> findCoachesWithAvgMarkAbove(@Param("minMark") double minMark);

}
