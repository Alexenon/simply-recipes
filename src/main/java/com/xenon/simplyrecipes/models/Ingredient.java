package com.xenon.simplyrecipes.models;

import lombok.Data;

@Data
public class Ingredient {
    String name;
    int amount;

    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
