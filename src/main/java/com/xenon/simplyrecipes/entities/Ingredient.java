package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    private int amount;

    @ManyToOne
    @Getter
    @Setter
    private Recipe recipe;

}
