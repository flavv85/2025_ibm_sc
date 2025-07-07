package com.unitbv.spring_boot_tutorial.service;

import com.unitbv.spring_boot_tutorial.entity.FitnessClass;
import com.unitbv.spring_boot_tutorial.repository.FitnessClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessClassService {
    @Autowired
    FitnessClassRepository fitnessClassRepository;

    public void saveFitnessClass(FitnessClass fitnessClass) {
        fitnessClassRepository.save(fitnessClass);
    }

    public List<FitnessClass> findAllFitnessClasses() {
        return fitnessClassRepository.findAll();
    }

    public Optional<FitnessClass> findFitnessClassById(String id) {
        return fitnessClassRepository.findById(id);
    }

    public void deleteFitnessClass(String id) {
        fitnessClassRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return fitnessClassRepository.existsById(id);
    }
}
