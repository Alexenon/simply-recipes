package com.xenon.simplyrecipes.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {
    String name;
    String description;
    List<Ingredient> ingredients;
    Integer duration;
    String imageName;
}
