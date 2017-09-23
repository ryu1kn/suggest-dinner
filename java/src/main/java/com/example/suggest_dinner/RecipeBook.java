package com.example.suggest_dinner;

import java.util.Collections;
import java.util.List;

public class RecipeBook {

    private int version = -1;
    private List<Recipe> recipes = Collections.emptyList();

    void setVersion(int version) {
        this.version = version;
    }

    void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

}
