package com.unitbv.spring_boot_tutorial.service;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import com.unitbv.spring_boot_tutorial.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    CoachRepository coachRepository;

    public void saveCoach(Coach coach){

        coachRepository.save(coach);

    }

    public List<Coach> findAllCoach(){
        return coachRepository.findAll();
    }

    public Optional<Coach> findCoachByName(String coachName){
        return coachRepository.findByNameContainingIgnoreCase(coachName);
    }
    public Coach findCoachById(String coachId){
        return coachRepository.getReferenceById(coachId);
    }
}
