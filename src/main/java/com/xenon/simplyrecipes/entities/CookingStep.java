package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cooking-steps")
@NoArgsConstructor
@AllArgsConstructor
public class CookingStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private String name;

    @ManyToOne
    @Getter
    @Setter
    private Recipe recipe;

}
