package com.example.suggest_dinner;

import java.util.Collections;
import java.util.List;

public class Recipe {

    private String name = "";
    private List<String> ingredients = Collections.emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean canCookWith(List<String> availableIngredients) {
        return ingredients.stream().allMatch(availableIngredients::contains);
    }

}
