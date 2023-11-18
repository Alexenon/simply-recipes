package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cooking_steps")
public class CookingStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String step;

    @ManyToOne
    @Getter
    @Setter
    private Recipe recipe;
}