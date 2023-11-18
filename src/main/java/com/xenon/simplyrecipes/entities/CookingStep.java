package com.xenon.simplyrecipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "recipe_id")
    @JsonIgnore
    @Getter
    @Setter
    private Recipe recipe;
}