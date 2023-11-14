package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Getter
    @Setter
    private Recipe recipe;

    @ManyToOne
    @Getter
    @Setter
    private Category category;

}
