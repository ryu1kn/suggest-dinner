package com.example.suggest_dinner;

import java.util.List;

public class RecipeBook {

    private int version;
    private List<Recipe> recipes;

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
