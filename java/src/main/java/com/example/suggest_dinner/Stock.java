package com.example.suggest_dinner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stock {

    private int version = -1;
    private List<Ingredient> ingredients = Collections.emptyList();

    public void setVersion(int version) {
        this.version = version;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients.stream()
                .map(ingredientName -> new Ingredient(ingredientName))
                .collect(Collectors.toList());
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}
