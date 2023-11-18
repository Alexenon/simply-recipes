package com.xenon.simplyrecipes.controllers;

import com.xenon.simplyrecipes.entities.Ingredient;
import com.xenon.simplyrecipes.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    public IngredientService ingredientService;

    @RequestMapping("/all")
    public List<Ingredient> getAll() {
        return ingredientService.getAllIngredients();
    }

    @RequestMapping("/add")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

}
