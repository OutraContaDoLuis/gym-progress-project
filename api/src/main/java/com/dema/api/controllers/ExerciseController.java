package com.dema.api.controllers;

import com.dema.api.entitys.ExerciseEntity;
import com.dema.api.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/get_all")
    public ResponseEntity<?> getAll() {
        List<ExerciseEntity> allExercises = exerciseService.getAllExercises();

        return ResponseEntity.ok(allExercises);
    }
}
