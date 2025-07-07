package com.unitbv.spring_boot_tutorial.controller;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import com.unitbv.spring_boot_tutorial.entity.FitnessClass;
import com.unitbv.spring_boot_tutorial.entity.Member;
import com.unitbv.spring_boot_tutorial.service.FitnessClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/fitness")
public class FitnessClassController {

    @Autowired
    FitnessClassService fitnessClassService;

    @PostMapping("create")
    public ResponseEntity<FitnessClass> createFitnessClass(@RequestBody FitnessClass fitnessClass) {
        fitnessClassService.saveFitnessClass(fitnessClass);
        return ResponseEntity.ok(fitnessClass);
    }

//    @PostMapping("create2")
//    public ResponseEntity<FitnessClass> createFitnessClass() {
//        FitnessClass fitnessClass = new FitnessClass();
//
//        fitnessClass.setId(UUID.randomUUID().toString());
//
//        fitnessClass.setStartTime(LocalDateTime.of(2025, 7, 8, 10, 0));
//        fitnessClass.setEndTime(LocalDateTime.of(2025, 7, 8, 12, 0));
//
//        Coach coach = new Coach();
//        coach.setId("241e38df-0cf3-4145-8af4-33ffb9fe6ba0");
//        coach.setName("Marcel");
//        fitnessClass.setCoach(coach);
//
//        Member m1 = new Member();
//        m1.setId("m1");
//        m1.setName("Alice");
//
//
//        Set<Member> members = new HashSet<>();
//        members.add(m1);
//
//        fitnessClass.setMembers(members);
//
//        fitnessClass.setIsReady(members.size() >= 3);
//
//        fitnessClassService.saveFitnessClass(fitnessClass);
//
//        return ResponseEntity.ok(fitnessClass);
//    }

    @GetMapping
    public ResponseEntity<List<FitnessClass>> getAllFitnessClasses() {
        return ResponseEntity.ok(fitnessClassService.findAllFitnessClasses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<FitnessClass> getFitnessClassById(@PathVariable String id) {
        Optional<FitnessClass> fitnessClass = fitnessClassService.findFitnessClassById(id);
        return fitnessClass.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitnessClass(@PathVariable String id) {
        if (fitnessClassService.existsById(id)) {
            fitnessClassService.deleteFitnessClass(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessClass> updateFitnessClass(
            @PathVariable String id,
            @RequestBody FitnessClass updatedFitnessClass) {

        Optional<FitnessClass> existing = fitnessClassService.findFitnessClassById(id);

        if (existing.isPresent()) {
            FitnessClass fitnessClass = existing.get();
            fitnessClass.setStartTime(updatedFitnessClass.getStartTime());
            fitnessClass.setEndTime(updatedFitnessClass.getEndTime());
            fitnessClass.setCoach(updatedFitnessClass.getCoach());
            fitnessClass.setMembers(updatedFitnessClass.getMembers());
            fitnessClass.setIsReady(updatedFitnessClass.isReady());

            fitnessClassService.saveFitnessClass(fitnessClass);
            return ResponseEntity.ok(fitnessClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
