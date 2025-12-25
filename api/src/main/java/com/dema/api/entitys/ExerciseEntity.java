package com.dema.api.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExerciseEntity {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}
