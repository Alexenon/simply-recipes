package com.xenon.simplyrecipes.data.requests;

import lombok.Data;

@Data
public class IngredientRequest {
    String name;
    int amount;
}
