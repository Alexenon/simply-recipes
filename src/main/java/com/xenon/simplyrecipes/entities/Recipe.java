package com.xenon.simplyrecipes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "recipes")
@Component
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

    @Getter
    @Setter
    private Integer cookingDuration; // In minutesу

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageName='" + imageName + '\'' +
                ", preparingDuration=" + preparingDuration +
                ", cookingDuration=" + cookingDuration +
                ", categories=" + categories +
                ", ingredients=" + ingredients +
                ", cookingSteps=" + cookingSteps +
                ", comments=" + comments +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
