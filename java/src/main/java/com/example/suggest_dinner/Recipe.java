package com.example.suggest_dinner;

import java.util.List;

public class Recipe {

    private final String name;
    private final List<Ingredient> ingredients;

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public boolean canCookWith(List<Ingredient> availableIngredients) {
        return ingredients.stream().allMatch(availableIngredients::contains);
    }

}