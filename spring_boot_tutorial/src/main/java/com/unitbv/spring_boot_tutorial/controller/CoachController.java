package com.unitbv.spring_boot_tutorial.controller;

import com.unitbv.spring_boot_tutorial.entity.Coach;
import com.unitbv.spring_boot_tutorial.repository.CoachRepository;
import com.unitbv.spring_boot_tutorial.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/get-coach")
    public List<Coach> getCoach() {

        return coachService.findAllCoach();
    }
    @PostMapping("/create-coach/{name}")
    public void createCoach(@PathVariable String name) {
        Coach coach = new Coach();
        coach.setName(name);
        coachService.saveCoach(coach);
    }

}
