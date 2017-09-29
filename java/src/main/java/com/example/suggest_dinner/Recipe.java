package com.example.suggest_dinner;

import java.util.Collections;
import java.util.Map;

public class Recipe {

    private String name = "";
    private Map<String, Integer> ingredients = Collections.emptyMap();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean canCookWith(Map<String, Integer> availableIngredients) {
        return ingredients.entrySet().stream()
                .allMatch(ingredient -> availableIngredients.getOrDefault(ingredient.getKey(), 0) >= ingredient.getValue());
    }

}
