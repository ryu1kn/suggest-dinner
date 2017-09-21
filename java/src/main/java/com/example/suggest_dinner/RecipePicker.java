package com.example.suggest_dinner;

import java.util.List;
import java.util.Optional;

public class RecipePicker {

    public final RecipeBook book;
    public final List<Ingredient> ingredients;

    public RecipePicker(RecipeBook book, List<Ingredient> ingredients) {
        this.book = book;
        this.ingredients = ingredients;
    }

    public Optional<Recipe> pick() {
        return book.getRecipes().stream()
                .filter(recipe -> recipe.canCookWith(ingredients))
                .findFirst();
    }

}
