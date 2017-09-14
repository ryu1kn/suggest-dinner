package com.example.suggest_dinner;

import java.util.List;
import java.util.Optional;

public class RecipePicker {

    public final List<Recipe> recipes;
    public final List<Ingredient> ingredients;

    public RecipePicker(List<Recipe> recipes, List<Ingredient> ingredients) {
        this.recipes = recipes;
        this.ingredients = ingredients;
    }

    public Optional<Recipe> pick() {
        return recipes.stream()
                .filter(recipe -> recipe.canCookWith(ingredients))
                .findFirst();
    }

}
