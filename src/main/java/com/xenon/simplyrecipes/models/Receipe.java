package com.xenon.simplyrecipes.models;

import lombok.Data;

import java.util.List;

@Data
public class Receipe {
    String name;
    String description;
    List<Ingredient> ingredients;
}
