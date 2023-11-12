package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "recipes")
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer durationInSeconds; // preparing duration in seconds

    @ManyToOne
    @Getter
    @Setter
    private Category category;

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
