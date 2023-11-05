package com.xenon.simplyrecipes.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Receipe {
    String name;
    String description;
    List<Ingredient> ingredients;
    Integer duration;
    String imageLocation;
}
