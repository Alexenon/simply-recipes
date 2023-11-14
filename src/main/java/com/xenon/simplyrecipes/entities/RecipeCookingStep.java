package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class RecipeCookingStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Getter
    @Setter
    private Recipe recipe;

    @Column(name = "step_name")
    @Getter
    @Setter
    private String stepName;
}