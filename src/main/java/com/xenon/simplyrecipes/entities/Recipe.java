package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "recipes")
@EqualsAndHashCode(exclude = {"ingredients"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String imageName;

    @Getter
    @Setter
    private Integer preparingDuration; // In minutes

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Category> categories;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<CookingStep> cookingSteps;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Comment> comments;

    @Getter
    @Setter
    private LocalDate dateCreated;

}
