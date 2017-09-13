package com.example.suggest_dinner;

import java.util.List;

public class Command {

    private final List<Recipe> recipes;

    public Command(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String execute() {
        return recipes.get(0).getName();
    }

}
