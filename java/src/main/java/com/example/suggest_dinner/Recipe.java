package com.example.suggest_dinner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe {

    private String name = "";
    private List<Ingredient> ingredients = Collections.emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients.stream()
                .map(ingredientName -> new Ingredient(ingredientName))
                .collect(Collectors.toList());
    }

    public boolean canCookWith(List<Ingredient> availableIngredients) {
        return ingredients.stream().allMatch(availableIngredients::contains);
    }

}
