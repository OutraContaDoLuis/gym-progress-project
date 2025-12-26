package com.dema.api.services;

import com.dema.api.entitys.ExerciseEntity;
import com.dema.api.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<ExerciseEntity> getAllExercises() {
        return exerciseRepository.findAll();
    }

}
